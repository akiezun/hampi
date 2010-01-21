// $ANTLR 3.1b1 src/hampi/parser/Hampi.g 2009-12-11 22:09:50
 
     package hampi.parser; 
   

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class HampiParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CFGPROD", "ASSIGN", "PROGRAM", "CFGOPTION", "CFGSTAR", "CFGPLUS", "FIX", "CONTAINS", "IN", "ASSERT", "CONCAT", "VAR", "CFG", "REG", "VAL", "CONST", "RANGE", "CHARSEQRANGE", "OR", "NOTIN", "NOTCONTAINS", "CFGCHARRANGE", "CFGCHARSEQRANGE", "CFGPRODELEMSET", "VALS", "SEMI", "KW_VAR", "ID", "COLON", "INT", "KW_CFG", "BAR", "LPAREN", "RPAREN", "QUESTION", "STAR", "PLUS", "LSQUARE", "CHAR_LIT", "MINUS", "RSQUARE", "CHAR_SEQ", "STR_LIT", "KW_REG", "KW_FIX", "COMMA", "KW_STAR", "KW_OR", "KW_CONCAT", "KW_VAL", "KW_ASSERT", "KW_IN", "KW_CONTAINS", "KW_NOT", "KW_QUERY", "EQUALS", "EscapeSequence", "NEWLINE", "WS", "COMMENT", "LINE_COMMENT", "'..'"
    };
    public static final int CFGSTAR=8;
    public static final int FIX=10;
    public static final int STAR=39;
    public static final int KW_VAL=53;
    public static final int T__65=65;
    public static final int LSQUARE=41;
    public static final int CFGPROD=4;
    public static final int CONST=19;
    public static final int CONTAINS=11;
    public static final int EQUALS=59;
    public static final int ID=31;
    public static final int CFG=16;
    public static final int EOF=-1;
    public static final int LPAREN=36;
    public static final int KW_VAR=30;
    public static final int VALS=28;
    public static final int CHAR_SEQ=45;
    public static final int RPAREN=37;
    public static final int IN=12;
    public static final int CFGOPTION=7;
    public static final int COMMA=49;
    public static final int CFGPRODELEMSET=27;
    public static final int CFGCHARRANGE=25;
    public static final int KW_IN=55;
    public static final int VAL=18;
    public static final int PLUS=40;
    public static final int VAR=15;
    public static final int COMMENT=63;
    public static final int NOTCONTAINS=24;
    public static final int KW_FIX=48;
    public static final int KW_REG=47;
    public static final int LINE_COMMENT=64;
    public static final int CONCAT=14;
    public static final int KW_ASSERT=54;
    public static final int STR_LIT=46;
    public static final int KW_QUERY=58;
    public static final int RANGE=20;
    public static final int INT=33;
    public static final int CHAR_LIT=42;
    public static final int RSQUARE=44;
    public static final int MINUS=43;
    public static final int REG=17;
    public static final int ASSERT=13;
    public static final int SEMI=29;
    public static final int CFGCHARSEQRANGE=26;
    public static final int CFGPLUS=9;
    public static final int COLON=32;
    public static final int WS=62;
    public static final int NEWLINE=61;
    public static final int KW_CONCAT=52;
    public static final int QUESTION=38;
    public static final int KW_OR=51;
    public static final int KW_CONTAINS=56;
    public static final int CHARSEQRANGE=21;
    public static final int OR=22;
    public static final int ASSIGN=5;
    public static final int PROGRAM=6;
    public static final int KW_STAR=50;
    public static final int EscapeSequence=60;
    public static final int BAR=35;
    public static final int KW_NOT=57;
    public static final int KW_CFG=34;
    public static final int NOTIN=23;

    // delegates
    // delegators


        public HampiParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public HampiParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return HampiParser.tokenNames; }
    public String getGrammarFileName() { return "src/hampi/parser/Hampi.g"; }


    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start program
    // src/hampi/parser/Hampi.g:47:2: program : ( statement SEMI )+ -> ^( PROGRAM ( statement )+ ) ;
    public final HampiParser.program_return program() throws RecognitionException {
        HampiParser.program_return retval = new HampiParser.program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMI2=null;
        HampiParser.statement_return statement1 = null;


        Object SEMI2_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // src/hampi/parser/Hampi.g:47:10: ( ( statement SEMI )+ -> ^( PROGRAM ( statement )+ ) )
            // src/hampi/parser/Hampi.g:47:12: ( statement SEMI )+
            {
            // src/hampi/parser/Hampi.g:47:12: ( statement SEMI )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==KW_VAR||LA1_0==KW_CFG||LA1_0==KW_REG||(LA1_0>=KW_VAL && LA1_0<=KW_ASSERT)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/hampi/parser/Hampi.g:47:13: statement SEMI
            	    {
            	    pushFollow(FOLLOW_statement_in_program276);
            	    statement1=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement1.getTree());
            	    SEMI2=(Token)match(input,SEMI,FOLLOW_SEMI_in_program278); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_SEMI.add(SEMI2);


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 47:30: -> ^( PROGRAM ( statement )+ )
            {
                // src/hampi/parser/Hampi.g:47:33: ^( PROGRAM ( statement )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGRAM, "PROGRAM"), root_1);

                if ( !(stream_statement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end program

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start statement
    // src/hampi/parser/Hampi.g:49:2: statement : ( vardeclStmt | cfgStmt | regStmt | valDeclStmt | assertStmt );
    public final HampiParser.statement_return statement() throws RecognitionException {
        HampiParser.statement_return retval = new HampiParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        HampiParser.vardeclStmt_return vardeclStmt3 = null;

        HampiParser.cfgStmt_return cfgStmt4 = null;

        HampiParser.regStmt_return regStmt5 = null;

        HampiParser.valDeclStmt_return valDeclStmt6 = null;

        HampiParser.assertStmt_return assertStmt7 = null;



        try {
            // src/hampi/parser/Hampi.g:49:12: ( vardeclStmt | cfgStmt | regStmt | valDeclStmt | assertStmt )
            int alt2=5;
            switch ( input.LA(1) ) {
            case KW_VAR:
                {
                alt2=1;
                }
                break;
            case KW_CFG:
                {
                alt2=2;
                }
                break;
            case KW_REG:
                {
                alt2=3;
                }
                break;
            case KW_VAL:
                {
                alt2=4;
                }
                break;
            case KW_ASSERT:
                {
                alt2=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // src/hampi/parser/Hampi.g:49:14: vardeclStmt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_vardeclStmt_in_statement299);
                    vardeclStmt3=vardeclStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, vardeclStmt3.getTree());

                    }
                    break;
                case 2 :
                    // src/hampi/parser/Hampi.g:50:14: cfgStmt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_cfgStmt_in_statement315);
                    cfgStmt4=cfgStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, cfgStmt4.getTree());

                    }
                    break;
                case 3 :
                    // src/hampi/parser/Hampi.g:51:14: regStmt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_regStmt_in_statement330);
                    regStmt5=regStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, regStmt5.getTree());

                    }
                    break;
                case 4 :
                    // src/hampi/parser/Hampi.g:52:14: valDeclStmt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_valDeclStmt_in_statement345);
                    valDeclStmt6=valDeclStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, valDeclStmt6.getTree());

                    }
                    break;
                case 5 :
                    // src/hampi/parser/Hampi.g:53:14: assertStmt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_assertStmt_in_statement360);
                    assertStmt7=assertStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assertStmt7.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end statement

    public static class vardeclStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start vardeclStmt
    // src/hampi/parser/Hampi.g:56:2: vardeclStmt : ( ( KW_VAR ID COLON INT '..' INT ) -> ^( VAR ID INT INT ) | ( KW_VAR ID COLON INT ) -> ^( VAR ID INT ) );
    public final HampiParser.vardeclStmt_return vardeclStmt() throws RecognitionException {
        HampiParser.vardeclStmt_return retval = new HampiParser.vardeclStmt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token KW_VAR8=null;
        Token ID9=null;
        Token COLON10=null;
        Token INT11=null;
        Token string_literal12=null;
        Token INT13=null;
        Token KW_VAR14=null;
        Token ID15=null;
        Token COLON16=null;
        Token INT17=null;

        Object KW_VAR8_tree=null;
        Object ID9_tree=null;
        Object COLON10_tree=null;
        Object INT11_tree=null;
        Object string_literal12_tree=null;
        Object INT13_tree=null;
        Object KW_VAR14_tree=null;
        Object ID15_tree=null;
        Object COLON16_tree=null;
        Object INT17_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleTokenStream stream_KW_VAR=new RewriteRuleTokenStream(adaptor,"token KW_VAR");

        try {
            // src/hampi/parser/Hampi.g:56:14: ( ( KW_VAR ID COLON INT '..' INT ) -> ^( VAR ID INT INT ) | ( KW_VAR ID COLON INT ) -> ^( VAR ID INT ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==KW_VAR) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==ID) ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2==COLON) ) {
                        int LA3_3 = input.LA(4);

                        if ( (LA3_3==INT) ) {
                            int LA3_4 = input.LA(5);

                            if ( (LA3_4==65) ) {
                                alt3=1;
                            }
                            else if ( (LA3_4==EOF||LA3_4==SEMI) ) {
                                alt3=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 3, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // src/hampi/parser/Hampi.g:56:18: ( KW_VAR ID COLON INT '..' INT )
                    {
                    // src/hampi/parser/Hampi.g:56:18: ( KW_VAR ID COLON INT '..' INT )
                    // src/hampi/parser/Hampi.g:56:19: KW_VAR ID COLON INT '..' INT
                    {
                    KW_VAR8=(Token)match(input,KW_VAR,FOLLOW_KW_VAR_in_vardeclStmt395); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_VAR.add(KW_VAR8);

                    ID9=(Token)match(input,ID,FOLLOW_ID_in_vardeclStmt397); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID9);

                    COLON10=(Token)match(input,COLON,FOLLOW_COLON_in_vardeclStmt399); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON10);

                    INT11=(Token)match(input,INT,FOLLOW_INT_in_vardeclStmt401); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT11);

                    string_literal12=(Token)match(input,65,FOLLOW_65_in_vardeclStmt403); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_65.add(string_literal12);

                    INT13=(Token)match(input,INT,FOLLOW_INT_in_vardeclStmt405); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT13);


                    }



                    // AST REWRITE
                    // elements: INT, INT, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 56:49: -> ^( VAR ID INT INT )
                    {
                        // src/hampi/parser/Hampi.g:56:52: ^( VAR ID INT INT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR, "VAR"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_INT.nextNode());
                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/hampi/parser/Hampi.g:57:21: ( KW_VAR ID COLON INT )
                    {
                    // src/hampi/parser/Hampi.g:57:21: ( KW_VAR ID COLON INT )
                    // src/hampi/parser/Hampi.g:57:22: KW_VAR ID COLON INT
                    {
                    KW_VAR14=(Token)match(input,KW_VAR,FOLLOW_KW_VAR_in_vardeclStmt441); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_VAR.add(KW_VAR14);

                    ID15=(Token)match(input,ID,FOLLOW_ID_in_vardeclStmt443); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID15);

                    COLON16=(Token)match(input,COLON,FOLLOW_COLON_in_vardeclStmt445); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON16);

                    INT17=(Token)match(input,INT,FOLLOW_INT_in_vardeclStmt447); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT17);


                    }



                    // AST REWRITE
                    // elements: INT, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 57:43: -> ^( VAR ID INT )
                    {
                        // src/hampi/parser/Hampi.g:57:46: ^( VAR ID INT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR, "VAR"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end vardeclStmt

    public static class cfgStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cfgStmt
    // src/hampi/parser/Hampi.g:60:2: cfgStmt : ( KW_CFG cfgProduction ) -> ^( CFG cfgProduction ) ;
    public final HampiParser.cfgStmt_return cfgStmt() throws RecognitionException {
        HampiParser.cfgStmt_return retval = new HampiParser.cfgStmt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token KW_CFG18=null;
        HampiParser.cfgProduction_return cfgProduction19 = null;


        Object KW_CFG18_tree=null;
        RewriteRuleTokenStream stream_KW_CFG=new RewriteRuleTokenStream(adaptor,"token KW_CFG");
        RewriteRuleSubtreeStream stream_cfgProduction=new RewriteRuleSubtreeStream(adaptor,"rule cfgProduction");
        try {
            // src/hampi/parser/Hampi.g:60:10: ( ( KW_CFG cfgProduction ) -> ^( CFG cfgProduction ) )
            // src/hampi/parser/Hampi.g:60:12: ( KW_CFG cfgProduction )
            {
            // src/hampi/parser/Hampi.g:60:12: ( KW_CFG cfgProduction )
            // src/hampi/parser/Hampi.g:60:13: KW_CFG cfgProduction
            {
            KW_CFG18=(Token)match(input,KW_CFG,FOLLOW_KW_CFG_in_cfgStmt486); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KW_CFG.add(KW_CFG18);

            pushFollow(FOLLOW_cfgProduction_in_cfgStmt488);
            cfgProduction19=cfgProduction();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_cfgProduction.add(cfgProduction19.getTree());

            }



            // AST REWRITE
            // elements: cfgProduction
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 60:35: -> ^( CFG cfgProduction )
            {
                // src/hampi/parser/Hampi.g:60:38: ^( CFG cfgProduction )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CFG, "CFG"), root_1);

                adaptor.addChild(root_1, stream_cfgProduction.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end cfgStmt

    public static class cfgProduction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cfgProduction
    // src/hampi/parser/Hampi.g:62:2: cfgProduction : ( ID ASSIGN cfgProductionSet ) -> ^( CFGPROD ID cfgProductionSet ) ;
    public final HampiParser.cfgProduction_return cfgProduction() throws RecognitionException {
        HampiParser.cfgProduction_return retval = new HampiParser.cfgProduction_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID20=null;
        Token ASSIGN21=null;
        HampiParser.cfgProductionSet_return cfgProductionSet22 = null;


        Object ID20_tree=null;
        Object ASSIGN21_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_cfgProductionSet=new RewriteRuleSubtreeStream(adaptor,"rule cfgProductionSet");
        try {
            // src/hampi/parser/Hampi.g:62:16: ( ( ID ASSIGN cfgProductionSet ) -> ^( CFGPROD ID cfgProductionSet ) )
            // src/hampi/parser/Hampi.g:62:18: ( ID ASSIGN cfgProductionSet )
            {
            // src/hampi/parser/Hampi.g:62:18: ( ID ASSIGN cfgProductionSet )
            // src/hampi/parser/Hampi.g:62:19: ID ASSIGN cfgProductionSet
            {
            ID20=(Token)match(input,ID,FOLLOW_ID_in_cfgProduction508); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID20);

            ASSIGN21=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_cfgProduction510); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN21);

            pushFollow(FOLLOW_cfgProductionSet_in_cfgProduction513);
            cfgProductionSet22=cfgProductionSet();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_cfgProductionSet.add(cfgProductionSet22.getTree());

            }



            // AST REWRITE
            // elements: ID, cfgProductionSet
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 62:49: -> ^( CFGPROD ID cfgProductionSet )
            {
                // src/hampi/parser/Hampi.g:62:52: ^( CFGPROD ID cfgProductionSet )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CFGPROD, "CFGPROD"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                adaptor.addChild(root_1, stream_cfgProductionSet.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end cfgProduction

    public static class cfgProductionSet_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cfgProductionSet
    // src/hampi/parser/Hampi.g:64:2: cfgProductionSet : ( cfgProductionElementSet ( BAR cfgProductionElementSet )* ) -> ( cfgProductionElementSet )+ ;
    public final HampiParser.cfgProductionSet_return cfgProductionSet() throws RecognitionException {
        HampiParser.cfgProductionSet_return retval = new HampiParser.cfgProductionSet_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BAR24=null;
        HampiParser.cfgProductionElementSet_return cfgProductionElementSet23 = null;

        HampiParser.cfgProductionElementSet_return cfgProductionElementSet25 = null;


        Object BAR24_tree=null;
        RewriteRuleTokenStream stream_BAR=new RewriteRuleTokenStream(adaptor,"token BAR");
        RewriteRuleSubtreeStream stream_cfgProductionElementSet=new RewriteRuleSubtreeStream(adaptor,"rule cfgProductionElementSet");
        try {
            // src/hampi/parser/Hampi.g:64:19: ( ( cfgProductionElementSet ( BAR cfgProductionElementSet )* ) -> ( cfgProductionElementSet )+ )
            // src/hampi/parser/Hampi.g:64:21: ( cfgProductionElementSet ( BAR cfgProductionElementSet )* )
            {
            // src/hampi/parser/Hampi.g:64:21: ( cfgProductionElementSet ( BAR cfgProductionElementSet )* )
            // src/hampi/parser/Hampi.g:64:22: cfgProductionElementSet ( BAR cfgProductionElementSet )*
            {
            pushFollow(FOLLOW_cfgProductionElementSet_in_cfgProductionSet537);
            cfgProductionElementSet23=cfgProductionElementSet();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_cfgProductionElementSet.add(cfgProductionElementSet23.getTree());
            // src/hampi/parser/Hampi.g:64:46: ( BAR cfgProductionElementSet )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==BAR) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/hampi/parser/Hampi.g:64:47: BAR cfgProductionElementSet
            	    {
            	    BAR24=(Token)match(input,BAR,FOLLOW_BAR_in_cfgProductionSet540); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_BAR.add(BAR24);

            	    pushFollow(FOLLOW_cfgProductionElementSet_in_cfgProductionSet542);
            	    cfgProductionElementSet25=cfgProductionElementSet();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cfgProductionElementSet.add(cfgProductionElementSet25.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }



            // AST REWRITE
            // elements: cfgProductionElementSet
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 64:78: -> ( cfgProductionElementSet )+
            {
                if ( !(stream_cfgProductionElementSet.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_cfgProductionElementSet.hasNext() ) {
                    adaptor.addChild(root_0, stream_cfgProductionElementSet.nextTree());

                }
                stream_cfgProductionElementSet.reset();

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end cfgProductionSet

    public static class cfgProductionElementSet_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cfgProductionElementSet
    // src/hampi/parser/Hampi.g:66:2: cfgProductionElementSet : ( ( cfgProductionElement )* ) -> ^( CFGPRODELEMSET ( cfgProductionElement )* ) ;
    public final HampiParser.cfgProductionElementSet_return cfgProductionElementSet() throws RecognitionException {
        HampiParser.cfgProductionElementSet_return retval = new HampiParser.cfgProductionElementSet_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        HampiParser.cfgProductionElement_return cfgProductionElement26 = null;


        RewriteRuleSubtreeStream stream_cfgProductionElement=new RewriteRuleSubtreeStream(adaptor,"rule cfgProductionElement");
        try {
            // src/hampi/parser/Hampi.g:66:26: ( ( ( cfgProductionElement )* ) -> ^( CFGPRODELEMSET ( cfgProductionElement )* ) )
            // src/hampi/parser/Hampi.g:66:28: ( ( cfgProductionElement )* )
            {
            // src/hampi/parser/Hampi.g:66:28: ( ( cfgProductionElement )* )
            // src/hampi/parser/Hampi.g:66:29: ( cfgProductionElement )*
            {
            // src/hampi/parser/Hampi.g:66:29: ( cfgProductionElement )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID||LA5_0==LPAREN||LA5_0==LSQUARE||(LA5_0>=CHAR_SEQ && LA5_0<=STR_LIT)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // src/hampi/parser/Hampi.g:0:0: cfgProductionElement
            	    {
            	    pushFollow(FOLLOW_cfgProductionElement_in_cfgProductionElementSet561);
            	    cfgProductionElement26=cfgProductionElement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_cfgProductionElement.add(cfgProductionElement26.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }



            // AST REWRITE
            // elements: cfgProductionElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 66:53: -> ^( CFGPRODELEMSET ( cfgProductionElement )* )
            {
                // src/hampi/parser/Hampi.g:66:56: ^( CFGPRODELEMSET ( cfgProductionElement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CFGPRODELEMSET, "CFGPRODELEMSET"), root_1);

                // src/hampi/parser/Hampi.g:66:73: ( cfgProductionElement )*
                while ( stream_cfgProductionElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_cfgProductionElement.nextTree());

                }
                stream_cfgProductionElement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end cfgProductionElementSet

    public static class cfgProductionElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cfgProductionElement
    // src/hampi/parser/Hampi.g:68:2: cfgProductionElement : ( cfgTerminal -> cfgTerminal | cfgNonterminal -> cfgNonterminal | LPAREN cfgNonterminal RPAREN QUESTION -> ^( CFGOPTION cfgNonterminal ) | LPAREN cfgNonterminal RPAREN STAR -> ^( CFGSTAR cfgNonterminal ) | LPAREN cfgNonterminal RPAREN PLUS -> ^( CFGPLUS cfgNonterminal ) | LSQUARE CHAR_LIT MINUS CHAR_LIT RSQUARE -> ^( CFGCHARRANGE CHAR_LIT CHAR_LIT ) | LSQUARE CHAR_SEQ MINUS CHAR_SEQ RSQUARE -> ^( CFGCHARSEQRANGE CHAR_SEQ CHAR_SEQ ) );
    public final HampiParser.cfgProductionElement_return cfgProductionElement() throws RecognitionException {
        HampiParser.cfgProductionElement_return retval = new HampiParser.cfgProductionElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN29=null;
        Token RPAREN31=null;
        Token QUESTION32=null;
        Token LPAREN33=null;
        Token RPAREN35=null;
        Token STAR36=null;
        Token LPAREN37=null;
        Token RPAREN39=null;
        Token PLUS40=null;
        Token LSQUARE41=null;
        Token CHAR_LIT42=null;
        Token MINUS43=null;
        Token CHAR_LIT44=null;
        Token RSQUARE45=null;
        Token LSQUARE46=null;
        Token CHAR_SEQ47=null;
        Token MINUS48=null;
        Token CHAR_SEQ49=null;
        Token RSQUARE50=null;
        HampiParser.cfgTerminal_return cfgTerminal27 = null;

        HampiParser.cfgNonterminal_return cfgNonterminal28 = null;

        HampiParser.cfgNonterminal_return cfgNonterminal30 = null;

        HampiParser.cfgNonterminal_return cfgNonterminal34 = null;

        HampiParser.cfgNonterminal_return cfgNonterminal38 = null;


        Object LPAREN29_tree=null;
        Object RPAREN31_tree=null;
        Object QUESTION32_tree=null;
        Object LPAREN33_tree=null;
        Object RPAREN35_tree=null;
        Object STAR36_tree=null;
        Object LPAREN37_tree=null;
        Object RPAREN39_tree=null;
        Object PLUS40_tree=null;
        Object LSQUARE41_tree=null;
        Object CHAR_LIT42_tree=null;
        Object MINUS43_tree=null;
        Object CHAR_LIT44_tree=null;
        Object RSQUARE45_tree=null;
        Object LSQUARE46_tree=null;
        Object CHAR_SEQ47_tree=null;
        Object MINUS48_tree=null;
        Object CHAR_SEQ49_tree=null;
        Object RSQUARE50_tree=null;
        RewriteRuleTokenStream stream_CHAR_SEQ=new RewriteRuleTokenStream(adaptor,"token CHAR_SEQ");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_LSQUARE=new RewriteRuleTokenStream(adaptor,"token LSQUARE");
        RewriteRuleTokenStream stream_CHAR_LIT=new RewriteRuleTokenStream(adaptor,"token CHAR_LIT");
        RewriteRuleTokenStream stream_QUESTION=new RewriteRuleTokenStream(adaptor,"token QUESTION");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_RSQUARE=new RewriteRuleTokenStream(adaptor,"token RSQUARE");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_cfgNonterminal=new RewriteRuleSubtreeStream(adaptor,"rule cfgNonterminal");
        RewriteRuleSubtreeStream stream_cfgTerminal=new RewriteRuleSubtreeStream(adaptor,"rule cfgTerminal");
        try {
            // src/hampi/parser/Hampi.g:68:23: ( cfgTerminal -> cfgTerminal | cfgNonterminal -> cfgNonterminal | LPAREN cfgNonterminal RPAREN QUESTION -> ^( CFGOPTION cfgNonterminal ) | LPAREN cfgNonterminal RPAREN STAR -> ^( CFGSTAR cfgNonterminal ) | LPAREN cfgNonterminal RPAREN PLUS -> ^( CFGPLUS cfgNonterminal ) | LSQUARE CHAR_LIT MINUS CHAR_LIT RSQUARE -> ^( CFGCHARRANGE CHAR_LIT CHAR_LIT ) | LSQUARE CHAR_SEQ MINUS CHAR_SEQ RSQUARE -> ^( CFGCHARSEQRANGE CHAR_SEQ CHAR_SEQ ) )
            int alt6=7;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // src/hampi/parser/Hampi.g:68:25: cfgTerminal
                    {
                    pushFollow(FOLLOW_cfgTerminal_in_cfgProductionElement584);
                    cfgTerminal27=cfgTerminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cfgTerminal.add(cfgTerminal27.getTree());


                    // AST REWRITE
                    // elements: cfgTerminal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 68:37: -> cfgTerminal
                    {
                        adaptor.addChild(root_0, stream_cfgTerminal.nextTree());

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/hampi/parser/Hampi.g:69:25: cfgNonterminal
                    {
                    pushFollow(FOLLOW_cfgNonterminal_in_cfgProductionElement614);
                    cfgNonterminal28=cfgNonterminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cfgNonterminal.add(cfgNonterminal28.getTree());


                    // AST REWRITE
                    // elements: cfgNonterminal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 69:40: -> cfgNonterminal
                    {
                        adaptor.addChild(root_0, stream_cfgNonterminal.nextTree());

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/hampi/parser/Hampi.g:70:25: LPAREN cfgNonterminal RPAREN QUESTION
                    {
                    LPAREN29=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_cfgProductionElement644); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN29);

                    pushFollow(FOLLOW_cfgNonterminal_in_cfgProductionElement646);
                    cfgNonterminal30=cfgNonterminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cfgNonterminal.add(cfgNonterminal30.getTree());
                    RPAREN31=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_cfgProductionElement648); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN31);

                    QUESTION32=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_cfgProductionElement650); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUESTION.add(QUESTION32);



                    // AST REWRITE
                    // elements: cfgNonterminal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 70:63: -> ^( CFGOPTION cfgNonterminal )
                    {
                        // src/hampi/parser/Hampi.g:70:66: ^( CFGOPTION cfgNonterminal )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CFGOPTION, "CFGOPTION"), root_1);

                        adaptor.addChild(root_1, stream_cfgNonterminal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/hampi/parser/Hampi.g:71:25: LPAREN cfgNonterminal RPAREN STAR
                    {
                    LPAREN33=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_cfgProductionElement684); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN33);

                    pushFollow(FOLLOW_cfgNonterminal_in_cfgProductionElement686);
                    cfgNonterminal34=cfgNonterminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cfgNonterminal.add(cfgNonterminal34.getTree());
                    RPAREN35=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_cfgProductionElement688); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN35);

                    STAR36=(Token)match(input,STAR,FOLLOW_STAR_in_cfgProductionElement690); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STAR.add(STAR36);



                    // AST REWRITE
                    // elements: cfgNonterminal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 71:63: -> ^( CFGSTAR cfgNonterminal )
                    {
                        // src/hampi/parser/Hampi.g:71:66: ^( CFGSTAR cfgNonterminal )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CFGSTAR, "CFGSTAR"), root_1);

                        adaptor.addChild(root_1, stream_cfgNonterminal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // src/hampi/parser/Hampi.g:72:25: LPAREN cfgNonterminal RPAREN PLUS
                    {
                    LPAREN37=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_cfgProductionElement732); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN37);

                    pushFollow(FOLLOW_cfgNonterminal_in_cfgProductionElement734);
                    cfgNonterminal38=cfgNonterminal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cfgNonterminal.add(cfgNonterminal38.getTree());
                    RPAREN39=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_cfgProductionElement736); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN39);

                    PLUS40=(Token)match(input,PLUS,FOLLOW_PLUS_in_cfgProductionElement738); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS40);



                    // AST REWRITE
                    // elements: cfgNonterminal
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 72:60: -> ^( CFGPLUS cfgNonterminal )
                    {
                        // src/hampi/parser/Hampi.g:72:63: ^( CFGPLUS cfgNonterminal )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CFGPLUS, "CFGPLUS"), root_1);

                        adaptor.addChild(root_1, stream_cfgNonterminal.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // src/hampi/parser/Hampi.g:73:25: LSQUARE CHAR_LIT MINUS CHAR_LIT RSQUARE
                    {
                    LSQUARE41=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_cfgProductionElement777); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LSQUARE.add(LSQUARE41);

                    CHAR_LIT42=(Token)match(input,CHAR_LIT,FOLLOW_CHAR_LIT_in_cfgProductionElement779); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR_LIT.add(CHAR_LIT42);

                    MINUS43=(Token)match(input,MINUS,FOLLOW_MINUS_in_cfgProductionElement781); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS43);

                    CHAR_LIT44=(Token)match(input,CHAR_LIT,FOLLOW_CHAR_LIT_in_cfgProductionElement783); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR_LIT.add(CHAR_LIT44);

                    RSQUARE45=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_cfgProductionElement785); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RSQUARE.add(RSQUARE45);



                    // AST REWRITE
                    // elements: CHAR_LIT, CHAR_LIT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 73:65: -> ^( CFGCHARRANGE CHAR_LIT CHAR_LIT )
                    {
                        // src/hampi/parser/Hampi.g:73:68: ^( CFGCHARRANGE CHAR_LIT CHAR_LIT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CFGCHARRANGE, "CFGCHARRANGE"), root_1);

                        adaptor.addChild(root_1, stream_CHAR_LIT.nextNode());
                        adaptor.addChild(root_1, stream_CHAR_LIT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // src/hampi/parser/Hampi.g:74:28: LSQUARE CHAR_SEQ MINUS CHAR_SEQ RSQUARE
                    {
                    LSQUARE46=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_cfgProductionElement824); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LSQUARE.add(LSQUARE46);

                    CHAR_SEQ47=(Token)match(input,CHAR_SEQ,FOLLOW_CHAR_SEQ_in_cfgProductionElement826); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR_SEQ.add(CHAR_SEQ47);

                    MINUS48=(Token)match(input,MINUS,FOLLOW_MINUS_in_cfgProductionElement828); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS48);

                    CHAR_SEQ49=(Token)match(input,CHAR_SEQ,FOLLOW_CHAR_SEQ_in_cfgProductionElement830); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR_SEQ.add(CHAR_SEQ49);

                    RSQUARE50=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_cfgProductionElement832); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RSQUARE.add(RSQUARE50);



                    // AST REWRITE
                    // elements: CHAR_SEQ, CHAR_SEQ
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 74:68: -> ^( CFGCHARSEQRANGE CHAR_SEQ CHAR_SEQ )
                    {
                        // src/hampi/parser/Hampi.g:74:71: ^( CFGCHARSEQRANGE CHAR_SEQ CHAR_SEQ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CFGCHARSEQRANGE, "CFGCHARSEQRANGE"), root_1);

                        adaptor.addChild(root_1, stream_CHAR_SEQ.nextNode());
                        adaptor.addChild(root_1, stream_CHAR_SEQ.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end cfgProductionElement

    public static class cfgTerminal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cfgTerminal
    // src/hampi/parser/Hampi.g:77:5: cfgTerminal : ( STR_LIT | CHAR_SEQ );
    public final HampiParser.cfgTerminal_return cfgTerminal() throws RecognitionException {
        HampiParser.cfgTerminal_return retval = new HampiParser.cfgTerminal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set51=null;

        Object set51_tree=null;

        try {
            // src/hampi/parser/Hampi.g:77:17: ( STR_LIT | CHAR_SEQ )
            // src/hampi/parser/Hampi.g:
            {
            root_0 = (Object)adaptor.nil();

            set51=(Token)input.LT(1);
            if ( (input.LA(1)>=CHAR_SEQ && input.LA(1)<=STR_LIT) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set51));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end cfgTerminal

    public static class cfgNonterminal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cfgNonterminal
    // src/hampi/parser/Hampi.g:80:5: cfgNonterminal : ID ;
    public final HampiParser.cfgNonterminal_return cfgNonterminal() throws RecognitionException {
        HampiParser.cfgNonterminal_return retval = new HampiParser.cfgNonterminal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID52=null;

        Object ID52_tree=null;

        try {
            // src/hampi/parser/Hampi.g:80:20: ( ID )
            // src/hampi/parser/Hampi.g:80:22: ID
            {
            root_0 = (Object)adaptor.nil();

            ID52=(Token)match(input,ID,FOLLOW_ID_in_cfgNonterminal933); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ID52_tree = (Object)adaptor.create(ID52);
            adaptor.addChild(root_0, ID52_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end cfgNonterminal

    public static class regStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start regStmt
    // src/hampi/parser/Hampi.g:82:5: regStmt : ( KW_REG ID ASSIGN regDefinition ) -> ^( REG ID regDefinition ) ;
    public final HampiParser.regStmt_return regStmt() throws RecognitionException {
        HampiParser.regStmt_return retval = new HampiParser.regStmt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token KW_REG53=null;
        Token ID54=null;
        Token ASSIGN55=null;
        HampiParser.regDefinition_return regDefinition56 = null;


        Object KW_REG53_tree=null;
        Object ID54_tree=null;
        Object ASSIGN55_tree=null;
        RewriteRuleTokenStream stream_KW_REG=new RewriteRuleTokenStream(adaptor,"token KW_REG");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_regDefinition=new RewriteRuleSubtreeStream(adaptor,"rule regDefinition");
        try {
            // src/hampi/parser/Hampi.g:82:13: ( ( KW_REG ID ASSIGN regDefinition ) -> ^( REG ID regDefinition ) )
            // src/hampi/parser/Hampi.g:82:15: ( KW_REG ID ASSIGN regDefinition )
            {
            // src/hampi/parser/Hampi.g:82:15: ( KW_REG ID ASSIGN regDefinition )
            // src/hampi/parser/Hampi.g:82:16: KW_REG ID ASSIGN regDefinition
            {
            KW_REG53=(Token)match(input,KW_REG,FOLLOW_KW_REG_in_regStmt950); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KW_REG.add(KW_REG53);

            ID54=(Token)match(input,ID,FOLLOW_ID_in_regStmt952); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID54);

            ASSIGN55=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_regStmt954); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN55);

            pushFollow(FOLLOW_regDefinition_in_regStmt956);
            regDefinition56=regDefinition();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_regDefinition.add(regDefinition56.getTree());

            }



            // AST REWRITE
            // elements: ID, regDefinition
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 82:48: -> ^( REG ID regDefinition )
            {
                // src/hampi/parser/Hampi.g:82:51: ^( REG ID regDefinition )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(REG, "REG"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                adaptor.addChild(root_1, stream_regDefinition.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end regStmt

    public static class regDefinition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start regDefinition
    // src/hampi/parser/Hampi.g:84:5: regDefinition : ( ID -> ID | STR_LIT -> STR_LIT | CHAR_SEQ -> CHAR_SEQ | ( KW_FIX LPAREN ID COMMA INT RPAREN ) -> ^( FIX ID INT ) | ( KW_STAR LPAREN regDefinition RPAREN ) -> ^( STAR regDefinition ) | ( LSQUARE CHAR_LIT MINUS CHAR_LIT RSQUARE ) -> ^( RANGE CHAR_LIT CHAR_LIT ) | ( LSQUARE CHAR_SEQ MINUS CHAR_SEQ RSQUARE ) -> ^( CHARSEQRANGE CHAR_SEQ CHAR_SEQ ) | ( KW_OR LPAREN regDefinition ( COMMA regDefinition )* RPAREN ) -> ^( OR ( regDefinition )+ ) | ( KW_CONCAT LPAREN regDefinition ( COMMA regDefinition )* RPAREN ) -> ^( CONCAT ( regDefinition )+ ) );
    public final HampiParser.regDefinition_return regDefinition() throws RecognitionException {
        HampiParser.regDefinition_return retval = new HampiParser.regDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID57=null;
        Token STR_LIT58=null;
        Token CHAR_SEQ59=null;
        Token KW_FIX60=null;
        Token LPAREN61=null;
        Token ID62=null;
        Token COMMA63=null;
        Token INT64=null;
        Token RPAREN65=null;
        Token KW_STAR66=null;
        Token LPAREN67=null;
        Token RPAREN69=null;
        Token LSQUARE70=null;
        Token CHAR_LIT71=null;
        Token MINUS72=null;
        Token CHAR_LIT73=null;
        Token RSQUARE74=null;
        Token LSQUARE75=null;
        Token CHAR_SEQ76=null;
        Token MINUS77=null;
        Token CHAR_SEQ78=null;
        Token RSQUARE79=null;
        Token KW_OR80=null;
        Token LPAREN81=null;
        Token COMMA83=null;
        Token RPAREN85=null;
        Token KW_CONCAT86=null;
        Token LPAREN87=null;
        Token COMMA89=null;
        Token RPAREN91=null;
        HampiParser.regDefinition_return regDefinition68 = null;

        HampiParser.regDefinition_return regDefinition82 = null;

        HampiParser.regDefinition_return regDefinition84 = null;

        HampiParser.regDefinition_return regDefinition88 = null;

        HampiParser.regDefinition_return regDefinition90 = null;


        Object ID57_tree=null;
        Object STR_LIT58_tree=null;
        Object CHAR_SEQ59_tree=null;
        Object KW_FIX60_tree=null;
        Object LPAREN61_tree=null;
        Object ID62_tree=null;
        Object COMMA63_tree=null;
        Object INT64_tree=null;
        Object RPAREN65_tree=null;
        Object KW_STAR66_tree=null;
        Object LPAREN67_tree=null;
        Object RPAREN69_tree=null;
        Object LSQUARE70_tree=null;
        Object CHAR_LIT71_tree=null;
        Object MINUS72_tree=null;
        Object CHAR_LIT73_tree=null;
        Object RSQUARE74_tree=null;
        Object LSQUARE75_tree=null;
        Object CHAR_SEQ76_tree=null;
        Object MINUS77_tree=null;
        Object CHAR_SEQ78_tree=null;
        Object RSQUARE79_tree=null;
        Object KW_OR80_tree=null;
        Object LPAREN81_tree=null;
        Object COMMA83_tree=null;
        Object RPAREN85_tree=null;
        Object KW_CONCAT86_tree=null;
        Object LPAREN87_tree=null;
        Object COMMA89_tree=null;
        Object RPAREN91_tree=null;
        RewriteRuleTokenStream stream_CHAR_SEQ=new RewriteRuleTokenStream(adaptor,"token CHAR_SEQ");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_KW_FIX=new RewriteRuleTokenStream(adaptor,"token KW_FIX");
        RewriteRuleTokenStream stream_LSQUARE=new RewriteRuleTokenStream(adaptor,"token LSQUARE");
        RewriteRuleTokenStream stream_KW_CONCAT=new RewriteRuleTokenStream(adaptor,"token KW_CONCAT");
        RewriteRuleTokenStream stream_KW_OR=new RewriteRuleTokenStream(adaptor,"token KW_OR");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_STR_LIT=new RewriteRuleTokenStream(adaptor,"token STR_LIT");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_KW_STAR=new RewriteRuleTokenStream(adaptor,"token KW_STAR");
        RewriteRuleTokenStream stream_CHAR_LIT=new RewriteRuleTokenStream(adaptor,"token CHAR_LIT");
        RewriteRuleTokenStream stream_RSQUARE=new RewriteRuleTokenStream(adaptor,"token RSQUARE");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_regDefinition=new RewriteRuleSubtreeStream(adaptor,"rule regDefinition");
        try {
            // src/hampi/parser/Hampi.g:84:19: ( ID -> ID | STR_LIT -> STR_LIT | CHAR_SEQ -> CHAR_SEQ | ( KW_FIX LPAREN ID COMMA INT RPAREN ) -> ^( FIX ID INT ) | ( KW_STAR LPAREN regDefinition RPAREN ) -> ^( STAR regDefinition ) | ( LSQUARE CHAR_LIT MINUS CHAR_LIT RSQUARE ) -> ^( RANGE CHAR_LIT CHAR_LIT ) | ( LSQUARE CHAR_SEQ MINUS CHAR_SEQ RSQUARE ) -> ^( CHARSEQRANGE CHAR_SEQ CHAR_SEQ ) | ( KW_OR LPAREN regDefinition ( COMMA regDefinition )* RPAREN ) -> ^( OR ( regDefinition )+ ) | ( KW_CONCAT LPAREN regDefinition ( COMMA regDefinition )* RPAREN ) -> ^( CONCAT ( regDefinition )+ ) )
            int alt9=9;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // src/hampi/parser/Hampi.g:84:21: ID
                    {
                    ID57=(Token)match(input,ID,FOLLOW_ID_in_regDefinition979); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID57);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 84:24: -> ID
                    {
                        adaptor.addChild(root_0, stream_ID.nextNode());

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/hampi/parser/Hampi.g:85:21: STR_LIT
                    {
                    STR_LIT58=(Token)match(input,STR_LIT,FOLLOW_STR_LIT_in_regDefinition1005); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STR_LIT.add(STR_LIT58);



                    // AST REWRITE
                    // elements: STR_LIT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 85:29: -> STR_LIT
                    {
                        adaptor.addChild(root_0, stream_STR_LIT.nextNode());

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/hampi/parser/Hampi.g:86:21: CHAR_SEQ
                    {
                    CHAR_SEQ59=(Token)match(input,CHAR_SEQ,FOLLOW_CHAR_SEQ_in_regDefinition1031); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR_SEQ.add(CHAR_SEQ59);



                    // AST REWRITE
                    // elements: CHAR_SEQ
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 86:30: -> CHAR_SEQ
                    {
                        adaptor.addChild(root_0, stream_CHAR_SEQ.nextNode());

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/hampi/parser/Hampi.g:87:21: ( KW_FIX LPAREN ID COMMA INT RPAREN )
                    {
                    // src/hampi/parser/Hampi.g:87:21: ( KW_FIX LPAREN ID COMMA INT RPAREN )
                    // src/hampi/parser/Hampi.g:87:22: KW_FIX LPAREN ID COMMA INT RPAREN
                    {
                    KW_FIX60=(Token)match(input,KW_FIX,FOLLOW_KW_FIX_in_regDefinition1059); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_FIX.add(KW_FIX60);

                    LPAREN61=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_regDefinition1061); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN61);

                    ID62=(Token)match(input,ID,FOLLOW_ID_in_regDefinition1063); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID62);

                    COMMA63=(Token)match(input,COMMA,FOLLOW_COMMA_in_regDefinition1065); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMMA.add(COMMA63);

                    INT64=(Token)match(input,INT,FOLLOW_INT_in_regDefinition1067); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT64);

                    RPAREN65=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_regDefinition1069); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN65);


                    }



                    // AST REWRITE
                    // elements: INT, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 87:57: -> ^( FIX ID INT )
                    {
                        // src/hampi/parser/Hampi.g:87:60: ^( FIX ID INT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FIX, "FIX"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_INT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // src/hampi/parser/Hampi.g:88:21: ( KW_STAR LPAREN regDefinition RPAREN )
                    {
                    // src/hampi/parser/Hampi.g:88:21: ( KW_STAR LPAREN regDefinition RPAREN )
                    // src/hampi/parser/Hampi.g:88:22: KW_STAR LPAREN regDefinition RPAREN
                    {
                    KW_STAR66=(Token)match(input,KW_STAR,FOLLOW_KW_STAR_in_regDefinition1103); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_STAR.add(KW_STAR66);

                    LPAREN67=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_regDefinition1105); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN67);

                    pushFollow(FOLLOW_regDefinition_in_regDefinition1107);
                    regDefinition68=regDefinition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regDefinition.add(regDefinition68.getTree());
                    RPAREN69=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_regDefinition1109); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN69);


                    }



                    // AST REWRITE
                    // elements: regDefinition
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 88:59: -> ^( STAR regDefinition )
                    {
                        // src/hampi/parser/Hampi.g:88:62: ^( STAR regDefinition )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STAR, "STAR"), root_1);

                        adaptor.addChild(root_1, stream_regDefinition.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // src/hampi/parser/Hampi.g:89:21: ( LSQUARE CHAR_LIT MINUS CHAR_LIT RSQUARE )
                    {
                    // src/hampi/parser/Hampi.g:89:21: ( LSQUARE CHAR_LIT MINUS CHAR_LIT RSQUARE )
                    // src/hampi/parser/Hampi.g:89:22: LSQUARE CHAR_LIT MINUS CHAR_LIT RSQUARE
                    {
                    LSQUARE70=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_regDefinition1141); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LSQUARE.add(LSQUARE70);

                    CHAR_LIT71=(Token)match(input,CHAR_LIT,FOLLOW_CHAR_LIT_in_regDefinition1143); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR_LIT.add(CHAR_LIT71);

                    MINUS72=(Token)match(input,MINUS,FOLLOW_MINUS_in_regDefinition1145); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS72);

                    CHAR_LIT73=(Token)match(input,CHAR_LIT,FOLLOW_CHAR_LIT_in_regDefinition1147); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR_LIT.add(CHAR_LIT73);

                    RSQUARE74=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_regDefinition1149); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RSQUARE.add(RSQUARE74);


                    }



                    // AST REWRITE
                    // elements: CHAR_LIT, CHAR_LIT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 89:63: -> ^( RANGE CHAR_LIT CHAR_LIT )
                    {
                        // src/hampi/parser/Hampi.g:89:66: ^( RANGE CHAR_LIT CHAR_LIT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RANGE, "RANGE"), root_1);

                        adaptor.addChild(root_1, stream_CHAR_LIT.nextNode());
                        adaptor.addChild(root_1, stream_CHAR_LIT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // src/hampi/parser/Hampi.g:90:21: ( LSQUARE CHAR_SEQ MINUS CHAR_SEQ RSQUARE )
                    {
                    // src/hampi/parser/Hampi.g:90:21: ( LSQUARE CHAR_SEQ MINUS CHAR_SEQ RSQUARE )
                    // src/hampi/parser/Hampi.g:90:22: LSQUARE CHAR_SEQ MINUS CHAR_SEQ RSQUARE
                    {
                    LSQUARE75=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_regDefinition1183); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LSQUARE.add(LSQUARE75);

                    CHAR_SEQ76=(Token)match(input,CHAR_SEQ,FOLLOW_CHAR_SEQ_in_regDefinition1185); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR_SEQ.add(CHAR_SEQ76);

                    MINUS77=(Token)match(input,MINUS,FOLLOW_MINUS_in_regDefinition1187); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS77);

                    CHAR_SEQ78=(Token)match(input,CHAR_SEQ,FOLLOW_CHAR_SEQ_in_regDefinition1189); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR_SEQ.add(CHAR_SEQ78);

                    RSQUARE79=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_regDefinition1191); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RSQUARE.add(RSQUARE79);


                    }



                    // AST REWRITE
                    // elements: CHAR_SEQ, CHAR_SEQ
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 90:63: -> ^( CHARSEQRANGE CHAR_SEQ CHAR_SEQ )
                    {
                        // src/hampi/parser/Hampi.g:90:66: ^( CHARSEQRANGE CHAR_SEQ CHAR_SEQ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CHARSEQRANGE, "CHARSEQRANGE"), root_1);

                        adaptor.addChild(root_1, stream_CHAR_SEQ.nextNode());
                        adaptor.addChild(root_1, stream_CHAR_SEQ.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // src/hampi/parser/Hampi.g:91:21: ( KW_OR LPAREN regDefinition ( COMMA regDefinition )* RPAREN )
                    {
                    // src/hampi/parser/Hampi.g:91:21: ( KW_OR LPAREN regDefinition ( COMMA regDefinition )* RPAREN )
                    // src/hampi/parser/Hampi.g:91:22: KW_OR LPAREN regDefinition ( COMMA regDefinition )* RPAREN
                    {
                    KW_OR80=(Token)match(input,KW_OR,FOLLOW_KW_OR_in_regDefinition1226); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_OR.add(KW_OR80);

                    LPAREN81=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_regDefinition1228); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN81);

                    pushFollow(FOLLOW_regDefinition_in_regDefinition1230);
                    regDefinition82=regDefinition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regDefinition.add(regDefinition82.getTree());
                    // src/hampi/parser/Hampi.g:91:49: ( COMMA regDefinition )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==COMMA) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // src/hampi/parser/Hampi.g:91:50: COMMA regDefinition
                    	    {
                    	    COMMA83=(Token)match(input,COMMA,FOLLOW_COMMA_in_regDefinition1233); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA83);

                    	    pushFollow(FOLLOW_regDefinition_in_regDefinition1235);
                    	    regDefinition84=regDefinition();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_regDefinition.add(regDefinition84.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    RPAREN85=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_regDefinition1239); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN85);


                    }



                    // AST REWRITE
                    // elements: regDefinition
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 91:80: -> ^( OR ( regDefinition )+ )
                    {
                        // src/hampi/parser/Hampi.g:91:83: ^( OR ( regDefinition )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OR, "OR"), root_1);

                        if ( !(stream_regDefinition.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_regDefinition.hasNext() ) {
                            adaptor.addChild(root_1, stream_regDefinition.nextTree());

                        }
                        stream_regDefinition.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // src/hampi/parser/Hampi.g:92:21: ( KW_CONCAT LPAREN regDefinition ( COMMA regDefinition )* RPAREN )
                    {
                    // src/hampi/parser/Hampi.g:92:21: ( KW_CONCAT LPAREN regDefinition ( COMMA regDefinition )* RPAREN )
                    // src/hampi/parser/Hampi.g:92:22: KW_CONCAT LPAREN regDefinition ( COMMA regDefinition )* RPAREN
                    {
                    KW_CONCAT86=(Token)match(input,KW_CONCAT,FOLLOW_KW_CONCAT_in_regDefinition1272); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_CONCAT.add(KW_CONCAT86);

                    LPAREN87=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_regDefinition1274); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN87);

                    pushFollow(FOLLOW_regDefinition_in_regDefinition1276);
                    regDefinition88=regDefinition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_regDefinition.add(regDefinition88.getTree());
                    // src/hampi/parser/Hampi.g:92:53: ( COMMA regDefinition )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==COMMA) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // src/hampi/parser/Hampi.g:92:54: COMMA regDefinition
                    	    {
                    	    COMMA89=(Token)match(input,COMMA,FOLLOW_COMMA_in_regDefinition1279); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA89);

                    	    pushFollow(FOLLOW_regDefinition_in_regDefinition1281);
                    	    regDefinition90=regDefinition();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_regDefinition.add(regDefinition90.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    RPAREN91=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_regDefinition1285); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN91);


                    }



                    // AST REWRITE
                    // elements: regDefinition
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 92:84: -> ^( CONCAT ( regDefinition )+ )
                    {
                        // src/hampi/parser/Hampi.g:92:87: ^( CONCAT ( regDefinition )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONCAT, "CONCAT"), root_1);

                        if ( !(stream_regDefinition.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_regDefinition.hasNext() ) {
                            adaptor.addChild(root_1, stream_regDefinition.nextTree());

                        }
                        stream_regDefinition.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end regDefinition

    public static class valDeclStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start valDeclStmt
    // src/hampi/parser/Hampi.g:95:2: valDeclStmt : ( KW_VAL ID ASSIGN expr ) -> ^( VAL ID expr ) ;
    public final HampiParser.valDeclStmt_return valDeclStmt() throws RecognitionException {
        HampiParser.valDeclStmt_return retval = new HampiParser.valDeclStmt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token KW_VAL92=null;
        Token ID93=null;
        Token ASSIGN94=null;
        HampiParser.expr_return expr95 = null;


        Object KW_VAL92_tree=null;
        Object ID93_tree=null;
        Object ASSIGN94_tree=null;
        RewriteRuleTokenStream stream_KW_VAL=new RewriteRuleTokenStream(adaptor,"token KW_VAL");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/hampi/parser/Hampi.g:95:14: ( ( KW_VAL ID ASSIGN expr ) -> ^( VAL ID expr ) )
            // src/hampi/parser/Hampi.g:95:16: ( KW_VAL ID ASSIGN expr )
            {
            // src/hampi/parser/Hampi.g:95:16: ( KW_VAL ID ASSIGN expr )
            // src/hampi/parser/Hampi.g:95:17: KW_VAL ID ASSIGN expr
            {
            KW_VAL92=(Token)match(input,KW_VAL,FOLLOW_KW_VAL_in_valDeclStmt1326); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KW_VAL.add(KW_VAL92);

            ID93=(Token)match(input,ID,FOLLOW_ID_in_valDeclStmt1328); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID93);

            ASSIGN94=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_valDeclStmt1330); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN94);

            pushFollow(FOLLOW_expr_in_valDeclStmt1332);
            expr95=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(expr95.getTree());

            }



            // AST REWRITE
            // elements: expr, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 95:40: -> ^( VAL ID expr )
            {
                // src/hampi/parser/Hampi.g:95:43: ^( VAL ID expr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAL, "VAL"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());
                adaptor.addChild(root_1, stream_expr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end valDeclStmt

    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expr
    // src/hampi/parser/Hampi.g:97:2: expr : ( STR_LIT -> STR_LIT | ID -> ID | ( KW_CONCAT LPAREN expr ( COMMA expr )* RPAREN ) -> ^( CONCAT ( expr )+ ) );
    public final HampiParser.expr_return expr() throws RecognitionException {
        HampiParser.expr_return retval = new HampiParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token STR_LIT96=null;
        Token ID97=null;
        Token KW_CONCAT98=null;
        Token LPAREN99=null;
        Token COMMA101=null;
        Token RPAREN103=null;
        HampiParser.expr_return expr100 = null;

        HampiParser.expr_return expr102 = null;


        Object STR_LIT96_tree=null;
        Object ID97_tree=null;
        Object KW_CONCAT98_tree=null;
        Object LPAREN99_tree=null;
        Object COMMA101_tree=null;
        Object RPAREN103_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_KW_CONCAT=new RewriteRuleTokenStream(adaptor,"token KW_CONCAT");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_STR_LIT=new RewriteRuleTokenStream(adaptor,"token STR_LIT");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // src/hampi/parser/Hampi.g:97:7: ( STR_LIT -> STR_LIT | ID -> ID | ( KW_CONCAT LPAREN expr ( COMMA expr )* RPAREN ) -> ^( CONCAT ( expr )+ ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case STR_LIT:
                {
                alt11=1;
                }
                break;
            case ID:
                {
                alt11=2;
                }
                break;
            case KW_CONCAT:
                {
                alt11=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // src/hampi/parser/Hampi.g:97:9: STR_LIT
                    {
                    STR_LIT96=(Token)match(input,STR_LIT,FOLLOW_STR_LIT_in_expr1353); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STR_LIT.add(STR_LIT96);



                    // AST REWRITE
                    // elements: STR_LIT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 97:17: -> STR_LIT
                    {
                        adaptor.addChild(root_0, stream_STR_LIT.nextNode());

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/hampi/parser/Hampi.g:98:9: ID
                    {
                    ID97=(Token)match(input,ID,FOLLOW_ID_in_expr1367); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID97);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 98:17: -> ID
                    {
                        adaptor.addChild(root_0, stream_ID.nextNode());

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/hampi/parser/Hampi.g:99:9: ( KW_CONCAT LPAREN expr ( COMMA expr )* RPAREN )
                    {
                    // src/hampi/parser/Hampi.g:99:9: ( KW_CONCAT LPAREN expr ( COMMA expr )* RPAREN )
                    // src/hampi/parser/Hampi.g:99:10: KW_CONCAT LPAREN expr ( COMMA expr )* RPAREN
                    {
                    KW_CONCAT98=(Token)match(input,KW_CONCAT,FOLLOW_KW_CONCAT_in_expr1387); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_CONCAT.add(KW_CONCAT98);

                    LPAREN99=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expr1389); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN99);

                    pushFollow(FOLLOW_expr_in_expr1391);
                    expr100=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expr.add(expr100.getTree());
                    // src/hampi/parser/Hampi.g:99:32: ( COMMA expr )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==COMMA) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/hampi/parser/Hampi.g:99:33: COMMA expr
                    	    {
                    	    COMMA101=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr1394); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA101);

                    	    pushFollow(FOLLOW_expr_in_expr1396);
                    	    expr102=expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(expr102.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    RPAREN103=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expr1400); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN103);


                    }



                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 99:54: -> ^( CONCAT ( expr )+ )
                    {
                        // src/hampi/parser/Hampi.g:99:57: ^( CONCAT ( expr )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONCAT, "CONCAT"), root_1);

                        if ( !(stream_expr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expr

    public static class assertStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start assertStmt
    // src/hampi/parser/Hampi.g:101:2: assertStmt : ( KW_ASSERT boolExpr ) -> ^( ASSERT boolExpr ) ;
    public final HampiParser.assertStmt_return assertStmt() throws RecognitionException {
        HampiParser.assertStmt_return retval = new HampiParser.assertStmt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token KW_ASSERT104=null;
        HampiParser.boolExpr_return boolExpr105 = null;


        Object KW_ASSERT104_tree=null;
        RewriteRuleTokenStream stream_KW_ASSERT=new RewriteRuleTokenStream(adaptor,"token KW_ASSERT");
        RewriteRuleSubtreeStream stream_boolExpr=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr");
        try {
            // src/hampi/parser/Hampi.g:101:13: ( ( KW_ASSERT boolExpr ) -> ^( ASSERT boolExpr ) )
            // src/hampi/parser/Hampi.g:101:15: ( KW_ASSERT boolExpr )
            {
            // src/hampi/parser/Hampi.g:101:15: ( KW_ASSERT boolExpr )
            // src/hampi/parser/Hampi.g:101:16: KW_ASSERT boolExpr
            {
            KW_ASSERT104=(Token)match(input,KW_ASSERT,FOLLOW_KW_ASSERT_in_assertStmt1421); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KW_ASSERT.add(KW_ASSERT104);

            pushFollow(FOLLOW_boolExpr_in_assertStmt1423);
            boolExpr105=boolExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_boolExpr.add(boolExpr105.getTree());

            }



            // AST REWRITE
            // elements: boolExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 101:36: -> ^( ASSERT boolExpr )
            {
                // src/hampi/parser/Hampi.g:101:39: ^( ASSERT boolExpr )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSERT, "ASSERT"), root_1);

                adaptor.addChild(root_1, stream_boolExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end assertStmt

    public static class boolExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start boolExpr
    // src/hampi/parser/Hampi.g:103:5: boolExpr : ( ( ID KW_IN ID ) -> ^( IN ID ID ) | ( ID KW_CONTAINS STR_LIT ) -> ^( CONTAINS ID STR_LIT ) | ( ID KW_NOT KW_IN ID ) -> ^( NOTIN ID ID ) | ( ID KW_NOT KW_CONTAINS STR_LIT ) -> ^( NOTCONTAINS ID STR_LIT ) );
    public final HampiParser.boolExpr_return boolExpr() throws RecognitionException {
        HampiParser.boolExpr_return retval = new HampiParser.boolExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ID106=null;
        Token KW_IN107=null;
        Token ID108=null;
        Token ID109=null;
        Token KW_CONTAINS110=null;
        Token STR_LIT111=null;
        Token ID112=null;
        Token KW_NOT113=null;
        Token KW_IN114=null;
        Token ID115=null;
        Token ID116=null;
        Token KW_NOT117=null;
        Token KW_CONTAINS118=null;
        Token STR_LIT119=null;

        Object ID106_tree=null;
        Object KW_IN107_tree=null;
        Object ID108_tree=null;
        Object ID109_tree=null;
        Object KW_CONTAINS110_tree=null;
        Object STR_LIT111_tree=null;
        Object ID112_tree=null;
        Object KW_NOT113_tree=null;
        Object KW_IN114_tree=null;
        Object ID115_tree=null;
        Object ID116_tree=null;
        Object KW_NOT117_tree=null;
        Object KW_CONTAINS118_tree=null;
        Object STR_LIT119_tree=null;
        RewriteRuleTokenStream stream_KW_IN=new RewriteRuleTokenStream(adaptor,"token KW_IN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_KW_CONTAINS=new RewriteRuleTokenStream(adaptor,"token KW_CONTAINS");
        RewriteRuleTokenStream stream_KW_NOT=new RewriteRuleTokenStream(adaptor,"token KW_NOT");
        RewriteRuleTokenStream stream_STR_LIT=new RewriteRuleTokenStream(adaptor,"token STR_LIT");

        try {
            // src/hampi/parser/Hampi.g:103:14: ( ( ID KW_IN ID ) -> ^( IN ID ID ) | ( ID KW_CONTAINS STR_LIT ) -> ^( CONTAINS ID STR_LIT ) | ( ID KW_NOT KW_IN ID ) -> ^( NOTIN ID ID ) | ( ID KW_NOT KW_CONTAINS STR_LIT ) -> ^( NOTCONTAINS ID STR_LIT ) )
            int alt12=4;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ID) ) {
                switch ( input.LA(2) ) {
                case KW_IN:
                    {
                    alt12=1;
                    }
                    break;
                case KW_CONTAINS:
                    {
                    alt12=2;
                    }
                    break;
                case KW_NOT:
                    {
                    int LA12_4 = input.LA(3);

                    if ( (LA12_4==KW_IN) ) {
                        alt12=3;
                    }
                    else if ( (LA12_4==KW_CONTAINS) ) {
                        alt12=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // src/hampi/parser/Hampi.g:104:16: ( ID KW_IN ID )
                    {
                    // src/hampi/parser/Hampi.g:104:16: ( ID KW_IN ID )
                    // src/hampi/parser/Hampi.g:104:17: ID KW_IN ID
                    {
                    ID106=(Token)match(input,ID,FOLLOW_ID_in_boolExpr1460); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID106);

                    KW_IN107=(Token)match(input,KW_IN,FOLLOW_KW_IN_in_boolExpr1462); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_IN.add(KW_IN107);

                    ID108=(Token)match(input,ID,FOLLOW_ID_in_boolExpr1464); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID108);


                    }



                    // AST REWRITE
                    // elements: ID, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 104:30: -> ^( IN ID ID )
                    {
                        // src/hampi/parser/Hampi.g:104:33: ^( IN ID ID )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IN, "IN"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // src/hampi/parser/Hampi.g:105:16: ( ID KW_CONTAINS STR_LIT )
                    {
                    // src/hampi/parser/Hampi.g:105:16: ( ID KW_CONTAINS STR_LIT )
                    // src/hampi/parser/Hampi.g:105:17: ID KW_CONTAINS STR_LIT
                    {
                    ID109=(Token)match(input,ID,FOLLOW_ID_in_boolExpr1493); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID109);

                    KW_CONTAINS110=(Token)match(input,KW_CONTAINS,FOLLOW_KW_CONTAINS_in_boolExpr1495); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_CONTAINS.add(KW_CONTAINS110);

                    STR_LIT111=(Token)match(input,STR_LIT,FOLLOW_STR_LIT_in_boolExpr1497); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STR_LIT.add(STR_LIT111);


                    }



                    // AST REWRITE
                    // elements: STR_LIT, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 105:41: -> ^( CONTAINS ID STR_LIT )
                    {
                        // src/hampi/parser/Hampi.g:105:44: ^( CONTAINS ID STR_LIT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONTAINS, "CONTAINS"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_STR_LIT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // src/hampi/parser/Hampi.g:106:16: ( ID KW_NOT KW_IN ID )
                    {
                    // src/hampi/parser/Hampi.g:106:16: ( ID KW_NOT KW_IN ID )
                    // src/hampi/parser/Hampi.g:106:17: ID KW_NOT KW_IN ID
                    {
                    ID112=(Token)match(input,ID,FOLLOW_ID_in_boolExpr1526); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID112);

                    KW_NOT113=(Token)match(input,KW_NOT,FOLLOW_KW_NOT_in_boolExpr1528); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_NOT.add(KW_NOT113);

                    KW_IN114=(Token)match(input,KW_IN,FOLLOW_KW_IN_in_boolExpr1530); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_IN.add(KW_IN114);

                    ID115=(Token)match(input,ID,FOLLOW_ID_in_boolExpr1532); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID115);


                    }



                    // AST REWRITE
                    // elements: ID, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 106:48: -> ^( NOTIN ID ID )
                    {
                        // src/hampi/parser/Hampi.g:106:51: ^( NOTIN ID ID )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NOTIN, "NOTIN"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // src/hampi/parser/Hampi.g:107:16: ( ID KW_NOT KW_CONTAINS STR_LIT )
                    {
                    // src/hampi/parser/Hampi.g:107:16: ( ID KW_NOT KW_CONTAINS STR_LIT )
                    // src/hampi/parser/Hampi.g:107:17: ID KW_NOT KW_CONTAINS STR_LIT
                    {
                    ID116=(Token)match(input,ID,FOLLOW_ID_in_boolExpr1572); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID116);

                    KW_NOT117=(Token)match(input,KW_NOT,FOLLOW_KW_NOT_in_boolExpr1574); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_NOT.add(KW_NOT117);

                    KW_CONTAINS118=(Token)match(input,KW_CONTAINS,FOLLOW_KW_CONTAINS_in_boolExpr1576); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KW_CONTAINS.add(KW_CONTAINS118);

                    STR_LIT119=(Token)match(input,STR_LIT,FOLLOW_STR_LIT_in_boolExpr1578); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STR_LIT.add(STR_LIT119);


                    }



                    // AST REWRITE
                    // elements: ID, STR_LIT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 107:48: -> ^( NOTCONTAINS ID STR_LIT )
                    {
                        // src/hampi/parser/Hampi.g:107:51: ^( NOTCONTAINS ID STR_LIT )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NOTCONTAINS, "NOTCONTAINS"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_STR_LIT.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end boolExpr

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA6_eotS =
        "\14\uffff";
    static final String DFA6_eofS =
        "\14\uffff";
    static final String DFA6_minS =
        "\1\37\2\uffff\1\37\1\52\1\45\2\uffff\1\46\3\uffff";
    static final String DFA6_maxS =
        "\1\56\2\uffff\1\37\1\55\1\45\2\uffff\1\50\3\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\3\uffff\1\6\1\7\1\uffff\1\3\1\4\1\5";
    static final String DFA6_specialS =
        "\14\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\2\4\uffff\1\3\4\uffff\1\4\3\uffff\2\1",
            "",
            "",
            "\1\5",
            "\1\6\2\uffff\1\7",
            "\1\10",
            "",
            "",
            "\1\11\1\12\1\13",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "68:2: cfgProductionElement : ( cfgTerminal -> cfgTerminal | cfgNonterminal -> cfgNonterminal | LPAREN cfgNonterminal RPAREN QUESTION -> ^( CFGOPTION cfgNonterminal ) | LPAREN cfgNonterminal RPAREN STAR -> ^( CFGSTAR cfgNonterminal ) | LPAREN cfgNonterminal RPAREN PLUS -> ^( CFGPLUS cfgNonterminal ) | LSQUARE CHAR_LIT MINUS CHAR_LIT RSQUARE -> ^( CFGCHARRANGE CHAR_LIT CHAR_LIT ) | LSQUARE CHAR_SEQ MINUS CHAR_SEQ RSQUARE -> ^( CFGCHARSEQRANGE CHAR_SEQ CHAR_SEQ ) );";
        }
    }
    static final String DFA9_eotS =
        "\13\uffff";
    static final String DFA9_eofS =
        "\13\uffff";
    static final String DFA9_minS =
        "\1\37\5\uffff\1\52\4\uffff";
    static final String DFA9_maxS =
        "\1\64\5\uffff\1\55\4\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\6\1\7";
    static final String DFA9_specialS =
        "\13\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1\11\uffff\1\6\3\uffff\1\3\1\2\1\uffff\1\4\1\uffff\1\5\1"+
            "\7\1\10",
            "",
            "",
            "",
            "",
            "",
            "\1\11\2\uffff\1\12",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "84:5: regDefinition : ( ID -> ID | STR_LIT -> STR_LIT | CHAR_SEQ -> CHAR_SEQ | ( KW_FIX LPAREN ID COMMA INT RPAREN ) -> ^( FIX ID INT ) | ( KW_STAR LPAREN regDefinition RPAREN ) -> ^( STAR regDefinition ) | ( LSQUARE CHAR_LIT MINUS CHAR_LIT RSQUARE ) -> ^( RANGE CHAR_LIT CHAR_LIT ) | ( LSQUARE CHAR_SEQ MINUS CHAR_SEQ RSQUARE ) -> ^( CHARSEQRANGE CHAR_SEQ CHAR_SEQ ) | ( KW_OR LPAREN regDefinition ( COMMA regDefinition )* RPAREN ) -> ^( OR ( regDefinition )+ ) | ( KW_CONCAT LPAREN regDefinition ( COMMA regDefinition )* RPAREN ) -> ^( CONCAT ( regDefinition )+ ) );";
        }
    }
 

    public static final BitSet FOLLOW_statement_in_program276 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_SEMI_in_program278 = new BitSet(new long[]{0x0060800440000002L});
    public static final BitSet FOLLOW_vardeclStmt_in_statement299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cfgStmt_in_statement315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regStmt_in_statement330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valDeclStmt_in_statement345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertStmt_in_statement360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_VAR_in_vardeclStmt395 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ID_in_vardeclStmt397 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_COLON_in_vardeclStmt399 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_INT_in_vardeclStmt401 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_vardeclStmt403 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_INT_in_vardeclStmt405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_VAR_in_vardeclStmt441 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ID_in_vardeclStmt443 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_COLON_in_vardeclStmt445 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_INT_in_vardeclStmt447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_CFG_in_cfgStmt486 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_cfgProduction_in_cfgStmt488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_cfgProduction508 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_in_cfgProduction510 = new BitSet(new long[]{0x0000621880000000L});
    public static final BitSet FOLLOW_cfgProductionSet_in_cfgProduction513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cfgProductionElementSet_in_cfgProductionSet537 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_BAR_in_cfgProductionSet540 = new BitSet(new long[]{0x0000621880000000L});
    public static final BitSet FOLLOW_cfgProductionElementSet_in_cfgProductionSet542 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_cfgProductionElement_in_cfgProductionElementSet561 = new BitSet(new long[]{0x0000621080000002L});
    public static final BitSet FOLLOW_cfgTerminal_in_cfgProductionElement584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cfgNonterminal_in_cfgProductionElement614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_cfgProductionElement644 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_cfgNonterminal_in_cfgProductionElement646 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_RPAREN_in_cfgProductionElement648 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_QUESTION_in_cfgProductionElement650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_cfgProductionElement684 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_cfgNonterminal_in_cfgProductionElement686 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_RPAREN_in_cfgProductionElement688 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_STAR_in_cfgProductionElement690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_cfgProductionElement732 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_cfgNonterminal_in_cfgProductionElement734 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_RPAREN_in_cfgProductionElement736 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_PLUS_in_cfgProductionElement738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_cfgProductionElement777 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_CHAR_LIT_in_cfgProductionElement779 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_MINUS_in_cfgProductionElement781 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_CHAR_LIT_in_cfgProductionElement783 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RSQUARE_in_cfgProductionElement785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_cfgProductionElement824 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_CHAR_SEQ_in_cfgProductionElement826 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_MINUS_in_cfgProductionElement828 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_CHAR_SEQ_in_cfgProductionElement830 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RSQUARE_in_cfgProductionElement832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_cfgTerminal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_cfgNonterminal933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_REG_in_regStmt950 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ID_in_regStmt952 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_in_regStmt954 = new BitSet(new long[]{0x001D620080000000L});
    public static final BitSet FOLLOW_regDefinition_in_regStmt956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_regDefinition979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_LIT_in_regDefinition1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_SEQ_in_regDefinition1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_FIX_in_regDefinition1059 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_LPAREN_in_regDefinition1061 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ID_in_regDefinition1063 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_COMMA_in_regDefinition1065 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_INT_in_regDefinition1067 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_RPAREN_in_regDefinition1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_STAR_in_regDefinition1103 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_LPAREN_in_regDefinition1105 = new BitSet(new long[]{0x001D620080000000L});
    public static final BitSet FOLLOW_regDefinition_in_regDefinition1107 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_RPAREN_in_regDefinition1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_regDefinition1141 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_CHAR_LIT_in_regDefinition1143 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_MINUS_in_regDefinition1145 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_CHAR_LIT_in_regDefinition1147 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RSQUARE_in_regDefinition1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_regDefinition1183 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_CHAR_SEQ_in_regDefinition1185 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_MINUS_in_regDefinition1187 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_CHAR_SEQ_in_regDefinition1189 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RSQUARE_in_regDefinition1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_OR_in_regDefinition1226 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_LPAREN_in_regDefinition1228 = new BitSet(new long[]{0x001D620080000000L});
    public static final BitSet FOLLOW_regDefinition_in_regDefinition1230 = new BitSet(new long[]{0x0002002000000000L});
    public static final BitSet FOLLOW_COMMA_in_regDefinition1233 = new BitSet(new long[]{0x001D620080000000L});
    public static final BitSet FOLLOW_regDefinition_in_regDefinition1235 = new BitSet(new long[]{0x0002002000000000L});
    public static final BitSet FOLLOW_RPAREN_in_regDefinition1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_CONCAT_in_regDefinition1272 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_LPAREN_in_regDefinition1274 = new BitSet(new long[]{0x001D620080000000L});
    public static final BitSet FOLLOW_regDefinition_in_regDefinition1276 = new BitSet(new long[]{0x0002002000000000L});
    public static final BitSet FOLLOW_COMMA_in_regDefinition1279 = new BitSet(new long[]{0x001D620080000000L});
    public static final BitSet FOLLOW_regDefinition_in_regDefinition1281 = new BitSet(new long[]{0x0002002000000000L});
    public static final BitSet FOLLOW_RPAREN_in_regDefinition1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_VAL_in_valDeclStmt1326 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ID_in_valDeclStmt1328 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_in_valDeclStmt1330 = new BitSet(new long[]{0x0010400080000000L});
    public static final BitSet FOLLOW_expr_in_valDeclStmt1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_LIT_in_expr1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_expr1367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_CONCAT_in_expr1387 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_LPAREN_in_expr1389 = new BitSet(new long[]{0x0010400080000000L});
    public static final BitSet FOLLOW_expr_in_expr1391 = new BitSet(new long[]{0x0002002000000000L});
    public static final BitSet FOLLOW_COMMA_in_expr1394 = new BitSet(new long[]{0x0010400080000000L});
    public static final BitSet FOLLOW_expr_in_expr1396 = new BitSet(new long[]{0x0002002000000000L});
    public static final BitSet FOLLOW_RPAREN_in_expr1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_ASSERT_in_assertStmt1421 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_boolExpr_in_assertStmt1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_boolExpr1460 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KW_IN_in_boolExpr1462 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ID_in_boolExpr1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_boolExpr1493 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_KW_CONTAINS_in_boolExpr1495 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_STR_LIT_in_boolExpr1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_boolExpr1526 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_KW_NOT_in_boolExpr1528 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KW_IN_in_boolExpr1530 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ID_in_boolExpr1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_boolExpr1572 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_KW_NOT_in_boolExpr1574 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_KW_CONTAINS_in_boolExpr1576 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_STR_LIT_in_boolExpr1578 = new BitSet(new long[]{0x0000000000000002L});

}