package main;

import fillers.Fillers;
import sorts.merge.MergeBubblesort;
import sorts.merge.MergeMyArrays;
import sorts.merge.MergeQsort;
import sorts.merge.MergeReversBubblesort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) {

        System.out.println("from basic main");
        //Analyzer.analyze();

        int as = 2;
        final int[] a;

        a = Fillers.randLastElement(as);

        MergeBubblesort mergeBS = new MergeBubblesort();
        MergeReversBubblesort mergeRB = new MergeReversBubblesort(a);
        MergeMyArrays mergeMA = new MergeMyArrays(a);
        MergeQsort mergeQ = new MergeQsort(a);

        //ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Thread threadBS = new Thread(mergeBS);
        Thread threadRB = new Thread(mergeRB);
        //Thread threadMA = new Thread(mergeMA);
        //Thread threadQ = new Thread(mergeQ);


//        threadPool.execute(mergeBS);
//        threadPool.execute(mergeRB);
//
//        threadPool.shutdown();

        threadBS.start();
        threadRB.start();
        //threadMA.start();
        //threadQ.start();


        try {
            threadBS.join(1000);
            threadRB.join(1000);
            //threadMA.join(1000);
            //threadQ.join(1000);
        } catch (InterruptedException e) {
        }

//        System.out.println("Time mergeBS " + mergeBS.getTime());
//        System.out.println("Time mergeRB " + mergeRB.getTime());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName());

        //threadPool.shutdown();

        //Map<String, Map<String, Map<String, Double>>> map = ReflectionNSizeMap.getNSizeSortMap(10);

//        System.out.println("\nThis is " + map.get("1").get("MyArrays"));
//        System.out.println("This is " + map.get("1").get("BubbleSort"));
//        System.out.println("This is " + map.get("1").get("Qsort"));
//        System.out.println("This is " + map.get("1").get("MergeMyArrays"));
//
//        System.out.println("\nThis is " + map.get("10").get("MyArrays"));
//        System.out.println("This is " + map.get("10").get("BubbleSort"));
//        System.out.println("This is " + map.get("10").get("Qsort"));
//        System.out.println("This is " + map.get("10").get("MergeMyArrays"));

        //System.out.println("\n" + map);
        //System.out.println(map.size());


        //LineChart.createSortChartDoc();

    }
}
