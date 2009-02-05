package hampi.experiments;

import static hampi.utils.CollectionsExt.subarray;
import hampi.utils.*;

import java.io.*;
import java.util.*;

/**
 * Performs an experiment to find attack string for SQL injection. The queries
 * come from Ardilla, an attack-finding tool for PHP (ICSE'09 Kiezun at al.).
 * The experiment is as follows. For both Hampi and CFGanalyzer (and any
 * additional solver we may find), we encode a query"find a string S of length N
 * such that when S is inserted as the query, the query is valid SQL statement
 * and contains an attack pattern." An attack pattern may be for example a
 * tautology "OR '1'='1'". The results are reported as time for each query,
 * tool, and N. (3 graphs : hampi times per query per N, cfg times, and time
 * ratios).
 */
public final class ExperimentSQLInjection{

  public static void main(String[] args) throws IOException{
    if (args.length != 3){
      System.out.println("Usage: ExperimentSQLInjection low high outputDir");
      System.out.println("  low is the min size of strings to try");
      System.out.println("  high is the max size of strings to try (suggested below 30)");
      System.out.println("  outputDir is where the results are placed");
      return;
    }
    int low = Integer.parseInt(args[0]);
    int high = Integer.parseInt(args[1]);
    assert high >= 1 && low <= high : "invalid values high=" + high + " low:" + low;
    File outputDir = new File(args[2]);
    if (!outputDir.exists()){
      outputDir.mkdirs();
    }

    //duplicate all output to log
    System.setErr(System.out);
    File logFile = new File(outputDir, "sqli_log.txt");
    System.setOut(new PrintStream(Files.tee(System.out, new FileOutputStream(logFile))));
    System.out.println(new Date() + " start");
    System.out.println("arguments: " + CollectionsExt.join(" ", args));
    System.out.println("Logging to " + logFile.getAbsolutePath());
    runSQLInjectionExperiment(low, high, outputDir);
    System.out.println(new Date() + " finished");
  }

  private static void runSQLInjectionExperiment(int low, int high, File outputDir) throws IOException{
    SolverExperimentResultSet<Pair<Boolean, Double>> hampiResults = new SolverExperimentResultSet<Pair<Boolean, Double>>("hampi");
    SolverExperimentResultSet<Pair<Boolean, Double>> cfgResults = new SolverExperimentResultSet<Pair<Boolean, Double>>("cfganalyzer");
    for (int i = low; i <= high; i++){
      runHampi(i, hampiResults);
      //      runCFGAnalyzer(i, cfgResults);

      SolverExperimentResultSet<Double> timeRatio = SolverExperimentResultSet.timeRatio(cfgResults, hampiResults, 0);
      HampiExperiments.createResultGraphs(hampiResults, cfgResults, "sqli", timeRatio, outputDir);
      HampiExperiments.printInRatioOrder(i, timeRatio);
    }
  }

  /**
   * For every query and every bad string, we encode in CFGanalyer a question of
   * finding a string that completes the query, is in the grammar, and contains
   * the bad string. Given a query s1 v s2, and variable of length n, we ask for
   * a string from the intersection of three grammars:<br>
   * S1 : s1 Sigma^n s2; <br>
   * S2 : SQL;<br>
   * S3 : Sigma* bad Sigma*; <br>
   * The result is a string that has the right prefix and suffix, is a valid SQL
   * query, and contains the bad string. The attack string v is then simply
   * extracted by dropping s1 and s2 from front and end.
   */
  private static void runCFGAnalyzer(int n, SolverExperimentResultSet<Pair<Boolean, Double>> cfgResults) throws IOException{
    System.out.println(n);
    String tinySQLGrammar = tinySQLGrammar();
    File sqlGrammarFile = File.createTempFile("sqli", ".cfg");
    Files.writeToFile(tinySQLGrammar, sqlGrammarFile);
    for (ArdillaSQLQuery query : queries()){
      String queryGrammar = query.toCFGAnalyzerGrammar(CFG2HMP.getTerminals(tinySQLGrammar), n);
      File queryGrammarFile = File.createTempFile("query", ".cfg");
      Files.writeToFile(queryGrammar, queryGrammarFile);
      for (String bad : badSQLStrings()){
        File badStringGrammarFile = File.createTempFile("bad", ".cfg");
        String badStringGrammar = grammarForContains(bad, CFG2HMP.getTerminals(tinySQLGrammar));
        Files.writeToFile(badStringGrammar, badStringGrammarFile);
        //        System.out.println(tinySQLGrammar);
        //        System.out.println(queryGrammar);
        //        System.out.println(badStringGrammar);
        //        System.out.println("------------");
        StringBuilder out = new StringBuilder();
        int size = query.size(n);
        System.out.println(query);
        System.out.println(bad);
        Pair<Boolean, Double> p = CFGAnalyzer.runIntersection(size, out, sqlGrammarFile, queryGrammarFile, badStringGrammarFile);
        cfgResults.addResult(resultName(query, bad), n, p);
        //        if (p.first){
        System.out.println("cfg " + p);
        System.out.println(out);
        //        }
        System.out.println("-----------------------");
        badStringGrammarFile.delete();
      }
      queryGrammarFile.delete();
    }
    sqlGrammarFile.delete();
  }

  /**
   * Returns the grammar, in CFG format:<br>
   * S : SigmaStar str SigmaStar;<br>
   * SigmaStar <br>
   * : ;<br>
   * : "a" SigmaStar ;<br>
   * ...<br>
   * : "z" SigmaStar ;<br>
   * <br>
   * (where a-z are the alphabet and str is split into 1-character strings.)
   */
  private static String grammarForContains(String str, Set<String> sigma){
    StringBuilder b = new StringBuilder();
    b.append("S : SigmaStar ").append(toChars(str)).append(" SigmaStar ;\n");
    b.append("SigmaStar\n");
    b.append(": ;\n");
    for (String s : sigma){
      b.append(": ").append(q(s)).append(" SigmaStar ;\n");
    }
    return b.toString();
  }

  /**
   * Runs the Hampi solver to find attacks with variable of length n. For every
   * query and every abd string, this tries to find a string that completes the
   * query such that you get valid SQL that contains the bad string.
   */
  private static void runHampi(int n, SolverExperimentResultSet<Pair<Boolean, Double>> hampiResults) throws IOException{
    String tinySQLGrammar = tinySQLGrammar();
    String hampiSQLGrammar = CFG2HMP.convertToHampiGrammar(tinySQLGrammar, "");
    System.out.println("size " + n);
    List<ArdillaSQLQuery> queryList = queries();
    System.out.println("unique queries " + new LinkedHashSet<ArdillaSQLQuery>(queryList).size());

    for (ArdillaSQLQuery query : queryList){
      for (String bad : badSQLStrings()){
        String constraint = createHampiSQLiConstraint(hampiSQLGrammar, n, query, bad);
        //                System.out.println("constraint");
        //        System.out.println(constraint);
        StringBuilder out = new StringBuilder();
        Pair<Boolean, Double> solveConstraint = HampiExperiments.solveConstraint(constraint, out);
        hampiResults.addResult(resultName(query, bad), n, solveConstraint);
        //if (solveConstraint.first){
        System.out.println("hampi " + solveConstraint);
          System.out.println(query);
          System.out.println(bad);
          System.out.println(out);
          System.out.println("--------------------------------------");
        //}
      }
    }
  }

  private static String resultName(ArdillaSQLQuery query, String bad){
    return query + "_" + bad;
  }

  private static String createHampiSQLiConstraint(String hampiSQLGrammar, int size, ArdillaSQLQuery query, String bad){
    String mainNonterminal = CFG2HMP.getMainNonterminalName(hampiSQLGrammar);
    StringBuilder b = new StringBuilder();
    String varName = "v";
    b.append("var " + varName + " : " + size + ";\n");
    b.append(hampiSQLGrammar);
    b.append("\n");
    b.append("reg sqlLimit" + "" + " := fix(" + mainNonterminal + ", " + query.size(size) + ");\n");
    b.append("val q := " + query.asVal(varName) + ";\n");
    b.append("assert q contains \"" + bad + "\";\n");
    b.append("assert q in sqlLimit;\n");
    return b.toString();
  }

  public static List<ArdillaSQLQuery> queries(){
    List<ArdillaSQLQuery> res = new ArrayList<ArdillaSQLQuery>();
    res.addAll(queriesGeccbblite());
    res.addAll(queriesEVE());
    res.addAll(queriesFAQForge());
    res.addAll(queriesSchoolmate());
    res.addAll(queriesWebchess());
    return res;
  }

  /**
   * Returns a tiny SQL grammar, in CFG analyzer format (so we can use it both
   * in Hampi and cfganalyzer).
   */
  private static String tinySQLGrammar(){
    StringBuilder b = new StringBuilder();
    b.append("SQL : SelectStmt OptCommentTail ;\n");
    b.append("    : UpdateStmt OptCommentTail ;\n");
    b.append("    : DeleteStmt OptCommentTail ;\n");
    b.append("OptCommentTail : ;\n");//ends with a comment followed by anything
    b.append("               : CommentStart SigmaStar ;\n");
    b.append("SigmaStar      : ;\n");
    b.append("               : Sigma SigmaStar ;\n");
    b.append("DeleteStmt : Delete From Id WhereCondOpt ;\n");
    b.append("UpdateStmt : Update Id Set AssignmentList WhereCondOpt ;\n");
    b.append("SelectStmt : Select ColumnSet From IdList WhereCondOpt OrderByOpt ;\n");
    b.append("AssignmentList : Assignment ;\n");
    b.append("               : Assignment Comma AssignmentList ;\n");
    b.append("Assignment : Id Eq Val ;\n");
    b.append("ColumnSet : Star ;\n");
    b.append("          : IdList ;\n");
    b.append("IdList  : Id ;\n");
    b.append("        : Id Comma IdList ;\n");
    b.append("OrderByOpt : OrderBy ;\n");
    b.append("             : ;\n");
    b.append("OrderBy : Order By Id;\n");
    b.append("WhereCondOpt : WhereCond ;\n");
    b.append("             : ;\n");
    b.append("WhereCond : Where Cond ;\n");
    b.append("Cond : Val Eq Val ;\n");
    b.append("     : Cond Or Cond ;\n");
    b.append("     : Cond And Cond ;\n");
    b.append("Val  : Id ;\n");
    b.append("     : Num ;\n");
    b.append("     : Quote Id Quote ;\n");
    b.append("     : Quote Quote ;\n");
    b.append("     : Quote Num Quote ;\n");
    //all terminals
    b.append("Sigma  : CommentStart ;\n");
    b.append("       : Or ;\n");
    b.append("       : And ;\n");
    b.append("       : Select ;\n");
    b.append("       : Star ;\n");
    b.append("       : From ;\n");
    b.append("       : Id ;\n");
    b.append("       : Num ;\n");
    b.append("       : Eq ;\n");
    b.append("       : Where ;\n");
    b.append("       : Comma ;\n");
    b.append("       : Quote  ;\n");
    b.append("       : Update  ;\n");
    b.append("       : Set  ;\n");
    b.append("       : Delete  ;\n");
    b.append("       : Order  ;\n");
    b.append("       : By ;\n");
    //terminals
    b.append("CommentStart : \"M\" ;\n");
    b.append("Or : \"O\" ;\n");
    b.append("And : \"A\" ;\n");
    b.append("Select : \"S\" ;\n");
    b.append("Star : \"R\" ;\n");
    b.append("From : \"F\" ;\n");
    b.append("Id : \"i\" ;\n");
    b.append("Num : \"n\" ;\n");
    b.append("Eq : \"Q\" ;\n");
    b.append("Where : \"W\" ;\n");
    b.append("Comma : \"C\" ;\n");
    b.append("Quote : \"T\" ;\n");
    b.append("Update : \"U\" ;\n");
    b.append("Set : \"E\" ;\n");
    b.append("Delete : \"D\" ;\n");
    b.append("Order : \"X\" ;\n");
    b.append("By : \"B\" ;\n");
    return b.toString();
  }

  /**
   * Strings that we do not want to see in SQL queries. Using the same shortcuts
   * for terminals as in the grammar.
   */
  public static List<String> badSQLStrings(){
    List<String> res = new ArrayList<String>();
    res.add("OnQn");
    res.add("OiQi");
    res.add("OTnTQTnT");
    res.add("OTiTQTiT");
    return res;
  }

  /**
   * {"f" "o"} -> : "f" ; <br>
   * : "o" ;<br>
   * Assume that strings in s are quoted.
   */
  private static String disjunct(Set<String> sigma){
    StringBuilder b = new StringBuilder();
    for (String s : sigma){
      b.append(": ").append(q(s)).append(" ;\n");
    }
    return b.toString();
  }

  /**
   * foo, 3 -> "foo" "foo" "foo"
   */
  private static String repeat(String s, int n){
    StringBuilder b = new StringBuilder(s.length() * n);
    for (int i = 0; i < n; i++){
      b.append(" ").append(s);
    }
    return b.toString();
  }

  /**
   * foo -> "f" "o" "o"
   */
  private static String toChars(String s){
    StringBuilder b = new StringBuilder(5 * s.length());
    for (char c : s.toCharArray()){
      b.append(q(String.valueOf(c))).append(" ");
    }
    return b.toString();
  }

  private static String q(String s){
    if (isQuoted(s))
      return s;
    else
      return "\"" + s + "\"";
  }

  private static boolean isQuoted(String s){
    return s.length() >= 2 && s.startsWith("\"") && s.endsWith("\"");
  }
  private static List<ArdillaSQLQuery> queriesFAQForge(){
    String v = ArdillaSQLQuery.VAR;
    List<ArdillaSQLQuery> res = new ArrayList<ArdillaSQLQuery>();
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT * FROM Faq WHERE context = '", v, "'" },//
        //        new String[] { "SELECT * FROM Faq WHERE context = '", "n", "'" }//
        new String[] { "SRFiWiQT", v, "T" },//
        new String[] { "SRFiWiQT", "n", "T" }//
        ));
    return res;
  }

  private static List<ArdillaSQLQuery> queriesSchoolmate(){
    String v = ArdillaSQLQuery.VAR;
    List<ArdillaSQLQuery> res = new ArrayList<ArdillaSQLQuery>();
        res.addAll(ArdillaSQLQuery.create(//
        //          new String[] { "select password from users where username = \"", v, "\"" },//
        //        new String[] { "select password from users where username = \"", "n", "\"" }//
        new String[] { "SiFiWiQT", v, "T" },//
        new String[] { "SiFiWiQT", "n", "T" }//
        ));
        res.addAll(ArdillaSQLQuery.create(//
            new String[] { "SiCiCiCiCiFiWiQ", v },//
            new String[] { "SiCiCiCiCiFiWiQ", "n" }//
        ));
        res.addAll(ArdillaSQLQuery.create(//
        new String[] { "UiEiQTTCiQTTCiQTTCiQTTCiQTTWiQT", v, "T" },//
        new String[] { "UiEiQTTCiQTTCiQTTCiQTTCiQTTWiQT", "n", "T" }//
        ));
        res.addAll(ArdillaSQLQuery.create(//
        new String[] { "UiEiQT", v, "TCiQT", v, "TCiQT", v, "TCiQT", v, "TCiQT", v, "TWiQT", v, "T" },//
        new String[] { "UiEiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQT", "n", "TWiQT", "n", "T" }//
        ));

    return res;
  }

  private static List<ArdillaSQLQuery> queriesWebchess(){
    String v = ArdillaSQLQuery.VAR;
    List<ArdillaSQLQuery> res = new ArrayList<ArdillaSQLQuery>();
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT playerID FROM players WHERE nick = '", v, "'" },//
        //        new String[] { "SELECT playerID FROM players WHERE nick = '", "n", "'" }//
        new String[] { "SiFiWiQT", v, "T" },//
        new String[] { "SiFiWiQT", "n", "T" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT * FROM players WHERE nick = '" ,v, "' AND password = ''" },//
        //        new String[] { "SELECT * FROM players WHERE nick = '", "n", "' AND password = ''" }//
        new String[] { "SRFiWiQT", v, "TAiQTT" },//
        new String[] { "SRFiWiQT", "n", "TAiQTT" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE games SET gameMessage = 'inviteDeclined', messageFrom = '", v, "' WHERE gameID =", v },//
        //        new String[] { "UPDATE games SET gameMessage = 'inviteDeclined', messageFrom = '", "n", "' WHERE gameID =", "n" }//
        new String[] { "UiEiQTiTCiQT", v, "TWiQ", v },//
        new String[] { "UiEiQTiTCiQT", "n", "TWiQ", "n" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE games SET gameMessage = '', messageFrom = '' WHERE gameID =", v },//
        //        new String[] { "UPDATE games SET gameMessage = '', messageFrom = '' WHERE gameID =", "n" }//
        new String[] { "UiEiQTTCiQTTWiQ", v },//
        new String[] { "UiEiQTTCiQTTWiQ", "n" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "DELETE FROM history WHERE gameID =", v },//
        //        new String[] { "DELETE FROM history WHERE gameID =", "n" }//
        new String[] { "DFiWiQ", v },//
        new String[] { "DFiWiQ", "n" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE games SET lastMove = NOW() WHERE gameID =" ,v },//
        //        new String[] { "UPDATE games SET lastMove = NOW() WHERE gameID =", "n" }//
        new String[] { "UiEiQnWiQ", v },//
        new String[] { "UiEiQnWiQ", "n" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE preferences SET value = '", v, "' WHERE playerID = -1 AND preference = 'theme'" },//
        //        new String[] { "UPDATE preferences SET value = '", "n", "' WHERE playerID = -1 AND preference = 'theme'" }//
        new String[] { "UiEiQT", v, "TWiQnAiQTiT" },//
        new String[] { "UiEiQT", "n", "TWiQnAiQTiT" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE preferences SET value = '", v, "' WHERE playerID = -1 AND preference = 'history'" },//
        //        new String[] { "UPDATE preferences SET value = '", "n", "' WHERE playerID = -1 AND preference = 'history'" }//
        new String[] { "UiEiQT", v, "TWiQnAiQTiT" },//
        new String[] { "UiEiQT", "n", "TWiQnAiQTiT" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE preferences SET value = '", v, "' WHERE playerID = -1 AND preference = 'emailnotification'" },//
        //        new String[] { "UPDATE preferences SET value = '", "n", "' WHERE playerID = -1 AND preference = 'emailnotification'" }//
        new String[] { "UiEiQT", v, "TWiQnAiQTiT" },//
        new String[] { "UiEiQT", "n", "TWiQnAiQTiT" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT nick FROM players, games WHERE playerID = whitePlayer AND gameID =", v },//
        //        new String[] { "SELECT nick FROM players, games WHERE playerID = whitePlayer AND gameID =", "n" }//
        new String[] { "SiFiCiWiQiAiQ", v },//
        new String[] { "SiFiCiWiQiAiQ", "n" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT nick FROM players, games WHERE playerID = blackPlayer AND gameID =", v },//
        //        new String[] { "SELECT nick FROM players, games WHERE playerID = blackPlayer AND gameID =", "n" }//
        new String[] { "SiFiCiWiQiAiQ", v },//
        new String[] { "SiFiCiWiQiAiQ", "n" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT * FROM history WHERE gameID =", v, " ORDER BY timeOfMove" },//
        //        new String[] { "SELECT * FROM history WHERE gameID =", "n", " ORDER BY timeOfMove" }//
        new String[] { "SRFiWiQ", v, "XBi" },//
        new String[] { "SRFiWiQ", "n", "XBi" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT * FROM pieces WHERE gameID =", v },//
        //        new String[] { "SELECT * FROM pieces WHERE gameID =", "n" }//
        new String[] { "SRFiWiQ", v },//
        new String[] { "SRFiWiQ", "n" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT whitePlayer, blackPlayer FROM games WHERE gameID =" . VAR(gameID)},//
        //        new String[] { "SELECT whitePlayer, blackPlayer FROM games WHERE gameID =" . VAR(gameID)},//
        new String[] { "SiCiFiWiQ", v },//
        new String[] { "SiCiFiWiQ", v }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT * FROM messages WHERE gameID =" . VAR(gameID) . " AND destination = 'black'"},//
        new String[] { "SRFiWiQ", v, "AiQTiT" },//
        new String[] { "SRFiWiQ", v, "AiQTiT" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT * FROM messages WHERE gameID =" . VAR(gameID) . " AND msgStatus = 'request' AND destination = 'white'"},//
        new String[] { "SRFiWiQ", v, "AiQTiTAiQTiT" },//
        new String[] { "SRFiWiQ", "n", "AiQTiTAiQTiT" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT gameMessage, messageFrom FROM games WHERE gameID =" . VAR(gameID)},//
        new String[] { "SiCiFiWiQ", v },//
        new String[] { "SiCiFiWiQ", "n" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT gameMessage, messageFrom FROM games WHERE gameID =" . VAR(gameID)},//
        new String[] { "SiCiFiWiQ", v },//
        new String[] { "SiCiFiWiQ", "n" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT password FROM players WHERE playerID =" . VAR(opponentsID)},//
        new String[] { "SiFiWiQ", v },//
        new String[] { "SiFiWiQ", "n" }//
        ));

    //TODO:"select curPiece,curColor,replaced from history where replaced > '' and gameID = '" . VAR(gameID) . "' order by curColor desc , replaced desc"

    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE history SET promotedTo = 'pawn', isInCheck = 1 WHERE gameID =", v, " AND timeOfMove = ''" },//
        //        new String[] { "UPDATE history SET promotedTo = 'pawn', isInCheck = 1 WHERE gameID =", "n", " AND timeOfMove = ''" }//
        new String[] { "UiEiQTiTCiQnWiQ", v, "AiQTT" },//
        new String[] { "UiEiQTiTCiQnWiQ", "n", "AiQTT" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] {"UPDATE games SET gameMessage = 'checkMate', messageFrom = 'white' WHERE gameID =" ,v },//
        //        new String[] { "UPDATE games SET gameMessage = 'checkMate', messageFrom = 'white' WHERE gameID =", "n" }//
        new String[] { "UiEiQTiTCiQTiTWiQ", v },//
        new String[] { "UiEiQTiTCiQTiTWiQ", "n" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE messages SET msgStatus = 'denied', destination = 'white' WHERE gameID =", v, " AND msgType = 'undo' AND msgStatus = 'request' AND destination = 'black'" },//
        //        new String[] { "UPDATE messages SET msgStatus = 'denied', destination = 'white' WHERE gameID =", "n", " AND msgType = 'undo' AND msgStatus = 'request' AND destination = 'black'" }//
        new String[] { "UiEiQTiTCiQTiTWiQ", v, "AiQTiTAiQTiTAiQTiT" },//
        new String[] { "UiEiQTiTCiQTiTWiQ", "n", "AiQTiTAiQTiTAiQTiT" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE messages SET msgStatus = 'denied', destination = 'white' WHERE gameID =" ,v, " AND msgType = 'draw' AND msgStatus = 'request' AND destination = 'black'" },//
        //        new String[] { "UPDATE messages SET msgStatus = 'denied', destination = 'white' WHERE gameID =", "n", " AND msgType = 'draw' AND msgStatus = 'request' AND destination = 'black'" }//
        new String[] { "UiEiQTiTCiQTiTWiQ", v, "AiQTiTAiQTiTAiQTiT" },//
        new String[] { "UiEiQTiTCiQTiTWiQ", "n", "AiQTiTAiQTiTAiQTiT" }//
        ));
    return res;
  }

  private static List<ArdillaSQLQuery> queriesEVE(){
    String v = ArdillaSQLQuery.VAR;
    List<ArdillaSQLQuery> res = new ArrayList<ArdillaSQLQuery>();
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE config SET welcome = '", v, "'" },//
        //        new String[] { "UPDATE config SET welcome = '1'" }//
        new String[] { "UiEiQT", v, "T" },//
        new String[] { "UiEiQT", "n", "T" }//
        ));
        res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE MembersMain SET Name = '", v, "', Division = '", v, "', RankCorp = '", v, "', Vacation = '", v, "', Comment = '", v, "', LastUpdate = n, Deleted = '", v,
        //            "' WHERE MemberID = '", v, "'" },//
        //        new String[] { "UPDATE MembersMain SET Name = '", "n", "', Division = '", "n", "', RankCorp = '", "n", "', Vacation = '", "n", "', Comment = '", "n", "', LastUpdate = n, Deleted = '", "n",
        //            "' WHERE MemberID = '", "n", "'" }//
                new String[] { "UiEiQT", v, "TCiQT", v, "TCiQT", v, "TCiQT", v, "TCiQT", v, "TCiQiCiQT", v, "TWiQT", v, "T" },//
                new String[] { "UiEiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQiCiQT", "n", "TWiQT", "n", "T" }//
            ));
    res.addAll(ArdillaSQLQuery.create(//
        new String[] { "UiEiQT", v, "TCiQT", v, "TCiQT", v, "TCiQT", v, "TCiQT", v, "TCiQT", v, "TWiQT", v, "T" },//
        new String[] { "UiEiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQT", "n", "TWiQT", "n", "T" }//
       ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT MemberID, Name, Division, DateJoined, RankCorp, Vacation, Comment, Deleted FROM MembersMain WHERE MemberID='", v, "'" },//
        //        new String[] { "SELECT MemberID, Name, Division, DateJoined, RankCorp, Vacation, Comment, Deleted FROM MembersMain WHERE MemberID='", "n", "'" }//
        new String[] { "SiCiCiCiCiCiCiCiFiWiQT", v, "T" },//
        new String[] { "SiCiCiCiCiCiCiCiFiWiQT", "n", "T" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE MembersMain SET Vacation = '", v, "' WHERE Name = '", v, "'" },//
        //        new String[] { "UPDATE MembersMain SET Vacation = '", "n", "' WHERE Name = '", "n", "'" }//
        new String[] { "UiEiQT", v, "TWiQT", v, "T" },//
        new String[] { "UiEiQT", "n", "TWiQT", "n", "T" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT MemberID, Name, Division, RankCorp, Vacation FROM MembersMain WHERE Name = '", v, "'" },//
        //        new String[] { "SELECT MemberID, Name, Division, RankCorp, Vacation FROM MembersMain WHERE Name = '", "n", "'" }//
        new String[] { "SiCiCiCiCiFiWiQT", v, "T" },//
        new String[] { "SiCiCiCiCiFiWiQT", "n", "T" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE MembersMain SET LastUpdate = Now() WHERE Name = '", v, "'" },//
        //        new String[] { "UPDATE MembersMain SET LastUpdate = Now() WHERE Name = '", "n", "'" }//
        new String[] { "UiEiQnWiQT", v, "T" },//
        new String[] { "UiEiQnWiQT", "n", "T" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        new String[] { "UiEiQT", v, "TCiQT", v, "TCiQT", v, "TCiQTnTCiQT", v, "TCiQnCiQT", v, "TWiQT", v, "T" },//
        new String[] { "UiEiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQTnTCiQT", "n", "TCiQnCiQT", "n", "TWiQT", "n", "T" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE MembersMain SET Name = '", v, "', Division = '", v, "', RankCorp = '", v, "', Vacation = '0', Comment = '", v, "', Deleted = '", v, "' WHERE MemberID = '", v, "'" },//
        //        new String[] { "UPDATE MembersMain SET Name = '", "n", "', Division = '", "n", "', RankCorp = '", "n", "', Vacation = '0', Comment = '", "n", "', Deleted = '", "n", "' WHERE MemberID = '",
        //            "n", "'" }//
        new String[] { "UiEiQT", v, "TCiQT", v, "TCiQT", v, "TCiQTnTCiQT", v, "TCiQT", v, "TWiQT", v, "T" },//
        new String[] { "UiEiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQTnTCiQT", "n", "TCiQT", "n", "TWiQT", "n", "T" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] {"UPDATE MembersMain SET Name = '" ,v, "', Division = '" ,v, "', RankCorp = '" ,v, "', Vacation = '" ,v, "', Comment = '" ,v, "', LastUpdate = Now(), Deleted = '0' WHERE MemberID = '" ,v, "'"},//
        //        new String[] { "UPDATE MembersMain SET Name = '", "n", "', Division = '", "n", "', RankCorp = '", "n", "', Vacation = '", "n", "', Comment = '", "n",
        //            "', LastUpdate = Now(), Deleted = '0' WHERE MemberID = '", "n", "'" }//
        new String[] { "UiEiQT", v, "TCiQT", v, "TCiQT", v, "TCiQT", v, "TCiQT", v, "TCiQnCiQTnTWiQT", v, "T" },//
        new String[] { "UiEiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQnCiQTnTWiQT", "n", "T" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] {"UPDATE MembersMain SET Name = '" ,v, "', Division = '" ,v, "', RankCorp = '" ,v, "', Vacation = '" ,v, "', Comment = '" ,v, "', Deleted = '0' WHERE MemberID = '" ,v, "'"},//
        //        new String[] { "UPDATE MembersMain SET Name = '", "n", "', Division = '", "n", "', RankCorp = '", "n", "', Vacation = '", "n", "', Comment = '", "n", "', Deleted = '0' WHERE MemberID = '",
        //            "n", "'" }//
        new String[] { "UiEiQT", v, "TCiQT", v, "TCiQT", v, "TCiQT", v, "TCiQT", v, "TCiQTnTWiQT", v, "T" },//
        new String[] { "UiEiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQTnTWiQT", "n", "T" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE MembersMain SET Name = '", v, "', Division = '", v, "', RankCorp = '", v, "', Vacation = '0', Comment = '", v,
        //            "', LastUpdate = Now(), Deleted = '0' WHERE MemberID = '", v, "'" },//
        //            new String[] { "UPDATE MembersMain SET Name = '", "n", "', Division = '", "n", "', RankCorp = '", "n", "', Vacation = '0', Comment = '", "n",
        //            "', LastUpdate = Now(), Deleted = '0' WHERE MemberID = '", "n", "'" }//
        new String[] { "UiEiQT", v, "TCiQT", v, "TCiQT", v, "TCiQTnTCiQT", v, "TCiQnCiQTnTWiQT", v, "T" },//
        new String[] { "UiEiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQTnTCiQT", "n", "TCiQnCiQTnTWiQT", "n", "T" }//
        ));
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "UPDATE MembersMain SET Name = '", v, "', Division = '", v, "', RankCorp = '", v, "', Vacation = '0', Comment = '", v, "', Deleted = '0' WHERE MemberID = '", v, "'" },//
        //        new String[] { "UPDATE MembersMain SET Name = '", "n", "', Division = '", "n", "', RankCorp = '", "n", "', Vacation = '0', Comment = '", "n", "', Deleted = '0' WHERE MemberID = '", "n", "'" }//
        new String[] { "UiEiQT", v, "TCiQT", v, "TCiQT", v, "TCiQTnTCiQT", v, "TCiQTnTWiQT", v, "T" },//
        new String[] { "UiEiQT", "n", "TCiQT", "n", "TCiQT", "n", "TCiQTnTCiQT", "n", "TCiQTnTWiQT", "n", "T" }//
        ));

    return res;
  }

  //this is for testing comments
  private static List<ArdillaSQLQuery> queriesFake(){
    String v = ArdillaSQLQuery.VAR;
    List<ArdillaSQLQuery> res = new ArrayList<ArdillaSQLQuery>();
    res.addAll(ArdillaSQLQuery.create(//
        //        new String[] { "SELECT * FROM messages WHERE gameID =" . VAR(gameID) . " AND msgStatus = 'request' AND destination = 'white'"},//
        new String[] { "SRF", v, "WiQnAiQTiTAiQTiT" },//
        new String[] { "SRF", "i", "WiQnAiQTiTAiQTiT" }//
        ));
    return res;
  }



  //returns the queries from the geccbblite program
  private static List<ArdillaSQLQuery> queriesGeccbblite(){
    String v = ArdillaSQLQuery.VAR;
    List<ArdillaSQLQuery> res = new ArrayList<ArdillaSQLQuery>();
    //    res.addAll(ArdillaSQLQuery.create(//
    //        new String[] { "SELECT * FROM geccBB_forum WHERE id=", v },//
    //        new String[] { "SELECT * FROM geccBB_forum WHERE id=", "1" }));//
    res.addAll(ArdillaSQLQuery.create(//
        new String[] { "SRFiWiQ", v },//
        new String[] { "SRFiWiQ", "n" }));//
    //    res.addAll(ArdillaSQLQuery.create(//
    //        new String[] { "SELECT id,rispostadel FROM geccBB_forum WHERE id=", v },//
    //        new String[] { "SELECT id,rispostadel FROM geccBB_forum WHERE id=", "1" }));//
    res.addAll(ArdillaSQLQuery.create(//
        new String[] { "SiCiFiWiQ", v },//
        new String[] { "SiCiFiWiQ", "n" }));//
    //    res.addAll(ArdillaSQLQuery.create(//
    //        new String[] { "SELECT * FROM geccBB_forum WHERE id=", v }, //
    //        new String[] { "SELECT * FROM geccBB_forum WHERE id=", "1" }));
    res.addAll(ArdillaSQLQuery.create(//
        new String[] { "SRFiWiQ", v }, //
        new String[] { "SRFiWiQ", "n" }));
    //    //    res.addAll(ArdillaSQLQuery.create(//
    //    //        new String[] { "INSERT INTO geccBB_forum VALUES(NULL, '", v, "', '1221844226', '", v, "', '", v, "", v, "', '", v, "')" },//
    //    //        new String[] { "INSERT INTO geccBB_forum VALUES(NULL, '", "1", "', '1221844226', '", "1", "', '", "1", "", "1", "', '", "1", "')" }));
    //    res.addAll(ArdillaSQLQuery.create(//
    //        new String[] { "NIiV(i,'", v, "','n','", v, "','", v, "", v, "','", v, "')" },//
    //        new String[] { "NIiV(i,'", "n", "','n','", "n", "','", "n", "", "n", "','", "n", "')" }));
    //    //    res.addAll(ArdillaSQLQuery.create(//
    //    //        new String[] { "INSERT INTO geccBB_forum VALUES(NULL, '", v, "', '1221844226', '", v, "', '", v, "", v, "', '')" },//
    //    //        new String[] { "INSERT INTO geccBB_forum VALUES(NULL, '", "1", "', '1221844226', '", "1", "', '", "1", "", "1", "', '')" }));
    //    res.addAll(ArdillaSQLQuery.create(//
    //        new String[] { "NIiV(i'", v, "','n','", v, "','", v, "", v, "','')" },//
    //        new String[] { "NIiV(i,'", "n", "','n','", "n", "','", "n", "", "n", "','')" }));
    return res;
  }


  /**
   * A query is a sequence: "s1 v s2" where s1 and s2 are constant strings and v
   * is a
   */
  public static final class ArdillaSQLQuery{
    public static final String VAR = "VAR"; //variable marker
    private final String s1;
    private final String s2;

    public static final Comparator<ArdillaSQLQuery> SIZE_ORDER = new Comparator<ArdillaSQLQuery>(){
      @Override
      public int compare(ArdillaSQLQuery o1, ArdillaSQLQuery o2){
        int sizeDiff = o1.size(0) - o2.size(0);
        if (sizeDiff != 0)
          return sizeDiff;
        return o1.asVal("v").compareTo(o2.asVal("v"));
      }
    };

    public ArdillaSQLQuery(String s1, String s2){
      assert s1 != null;
      assert s2 != null;
      this.s1 = s1;
      this.s2 = s2;
    }

    /**
     * Returns the grammar: S : s1 Sigma^n s2;<br>
     * Assumes that all terminals have 1 character.
     */
    public String toCFGAnalyzerGrammar(Set<String> sigma, int n){
      StringBuilder b = new StringBuilder();
      b.append("S : ").append(toChars(s1)).append(repeat("Sigma", n)).append(toChars(s2)).append(" ;\n");
      b.append("Sigma ").append(disjunct(sigma));
      return b.toString();
    }

    /**
     * Returns this query as a Hampi 'val' (variable defined as concatenation of
     * constants and var).
     */
    public String asVal(String varName){
      if (s1.isEmpty() && s2.isEmpty())
        return varName;
      if (!s1.isEmpty() && !s2.isEmpty())
        return "concat(" + q(s1) + ", " + varName + ", " + q(s2) + ")";
      if (s1.isEmpty())
        return "concat(" + varName + ", " + q(s2) + ")";
      return "concat(" + q(s1) + ", " + varName + ")";
    }

    /**
     * Returns the length of the query given the size of the variable.
     */
    public int size(int size){
      return s1.length() + s2.length() + size;
    }

    /**
     * Creates a set of queries, one for each occurrence of the variable marker.
     * The other occurrences will be replaced with concrete values.
     */
    public static Set<ArdillaSQLQuery> create(String[] symbolicStrings, String[] concreteStrings){
      assert symbolicStrings.length == concreteStrings.length : symbolicStrings.length + " " + concreteStrings.length;
      Set<ArdillaSQLQuery> res = new LinkedHashSet<ArdillaSQLQuery>();
      for (int i = 0; i < symbolicStrings.length; i++){
        if (!symbolicStrings[i].equals(VAR)){
          continue;
        }
        String s1 = concretes(concreteStrings, 0, i);
        String s2 = concretes(concreteStrings, i + 1, symbolicStrings.length - i - 1);
        res.add(new ArdillaSQLQuery(s1, s2));
      }
      assert !res.isEmpty() : "no variable marker in " + Arrays.toString(symbolicStrings);
      return res;
    }

    private static String concretes(String[] concreteStrings, int startIdx, int len){
      String[] subarray = subarray(concreteStrings, startIdx, len);
      return CollectionsExt.join("", Arrays.asList(subarray));
    }

    @Override
    public boolean equals(Object obj){
      if (!(obj instanceof ArdillaSQLQuery))
        return false;
      ArdillaSQLQuery that = (ArdillaSQLQuery) obj;
      return this.s1.equals(that.s1) && this.s2.equals(that.s2);
    }

    @Override
    public int hashCode(){
      return s1.hashCode() * s2.hashCode();
    }

    @Override
    public String toString(){
      return s1 + " . var . " + s2;
    }
  }
}
