package hampi.experiments;

import hampi.experiments.ExperimentSQLInjection.ArdillaSQLQuery;
import hampi.utils.*;

import java.io.IOException;
import java.util.*;

public class ExperimentSQLIAnalyze{
  public static void main(String[] args) throws IOException{
    List<ArdillaSQLQuery> queries = ExperimentSQLInjection.queries();
    List<ArdillaSQLQuery> queriesSortedBySize = new ArrayList<ArdillaSQLQuery>(queries);
    Collections.sort(queriesSortedBySize, ArdillaSQLQuery.SIZE_ORDER);
    List<String> badSQLStrings = ExperimentSQLInjection.badSQLStrings();

    BigTable sat = BigTable.readFromFile("sqli_hmp_sat.txt");
    BigTable times = BigTable.readFromFile("sqli_hmp.data");
    System.out.println(sat.columnCount(0) - 1);//subtract 1 for the 'size' column
    //    System.out.println(times);

    System.out.println("queries:" + queries.size());
    Set<ArdillaSQLQuery> uniqueQueries = new LinkedHashSet<ArdillaSQLQuery>(queries);
    List<ArdillaSQLQuery> uniqueQueryList = new ArrayList<ArdillaSQLQuery>(uniqueQueries);
    System.out.println("unique queries:" + uniqueQueries.size());

    int variableSize = 9;
    //    sizeTime_avg(badSQLStrings, times, uniqueQueryList, variableSize);
    //goal: create a graph of (query size vs time, one point per input size)

    //% of sat per size
    for (int size = 1; size <= 9; size++){
      System.out.println(size + " " + sat.columnCount(size - 1));
      //      int satCount=0;
      //       for (int i = 1; i < sat.columnCount(size - 1); i++){
      //         List<Integer> iColumn = sat.intColumn(i);
      //         List<Integer> sumColumn = iColumn.subList(0, size);
      //         boolean satUntilI = 0 < CollectionsExt.sumInts(sumColumn);
      //         if (satUntilI){
      //          satCount++;
      //        }
      //       }
      //      System.out.println(size + " : " + satCount + " " + (satCount * 1.0 / sat.columnCount(size - 1)));
    }

    //graph of time vs solvable (line per size)
    //    solvableQueries(times);
  }

  private static void solvableQueries(BigTable times) throws IOException{
    for (int size = 1; size <= 9; size++){
    List<Integer> timesForSize = times.intRow(size - 1);
    Collections.sort(timesForSize);
    timesForSize = timesForSize.subList(1, timesForSize.size());//1st column is the size
    int allTimes = timesForSize.size();
    Collections.sort(timesForSize);
    StringBuilder b = new StringBuilder();
    SortedMap<Integer, Double> solvables = new TreeMap<Integer, Double>();
    for (int i = 0; i < allTimes; i++){
      int time = timesForSize.get(i);
      double percentage = (i * 100.0) / (allTimes - 1);
      solvables.put(time, percentage);//replaces any old mapping on purpose to take the last
    }
    for (int time : solvables.keySet()){
      System.out.println(time + " " + solvables.get(time));
      b.append(time).append(" ").append(solvables.get(time)).append(Utils.newLine);
    }
    Files.writeToFile(b.toString(), "sqli_solvable_" + size + ".data");
    }
  }

  private static void sizeTime_avg(List<String> badSQLStrings, BigTable times, List<ArdillaSQLQuery> uniqueQueryList, int variableSize){
    int column = 1;//skip the size column
    SortedMap<Integer, List<Integer>> timesPerSize = new TreeMap<Integer, List<Integer>>();
    for (int i = 0; i < uniqueQueryList.size(); i++){
      ArdillaSQLQuery q = uniqueQueryList.get(i);
      int querySize = q.size(0);
      for (int j = 0; j < badSQLStrings.size(); j++){
        int time = times.intCell(variableSize - 1, column++);
        int badStringSize = badSQLStrings.get(j).length();
        int inputSize = querySize + badStringSize;
        List<Integer> timeList = timesPerSize.get(inputSize);
        if (timeList == null){
          timeList = new ArrayList<Integer>(1);
          timesPerSize.put(inputSize, timeList);
        }
        timeList.add(time);
      }
    }
    for (int size : timesPerSize.keySet()){
      List<Integer> list = timesPerSize.get(size);
            double meanTime = CollectionsExt.meanInts(list);
            System.out.println(size + " " + meanTime);
      //      for (int time : list){
      //        System.out.println(size + " " + time);
      //      }
    }
  }
}
