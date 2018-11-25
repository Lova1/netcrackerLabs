package main;

//import analyzer.Analyzer;
import bubblesort.BubbleSort;
import byhalf.ByHalf;
import fillers.Fillers;
import myarrays.MyArrays;
//import output.OutputResult;
import qsort.Qsort;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        OutputResult op = new OutputResult();
//        op.output();
//
//        Analyzer analyzer = new Analyzer();
//        analyzer.analyze();

        System.out.println("from basic main");

        int as = 2;

        final int[] a;
        a = Fillers.reverseSort(as);

        Qsort q = new Qsort();
        q.sort(a);
        q.getTime();
        System.out.println("\n");

        MyArrays m = new MyArrays();
        m.sort(a);
        System.out.println("\n");
        m.getTime();
        System.out.println("\n");

        BubbleSort b = new BubbleSort();
        b.sort(a);
        System.out.println("\n");
        m.getTime();
        System.out.println("\n");
        b.reverseSort(a);
        System.out.println("\n");
        b.getTime();
        System.out.println("\n");

        ByHalf byHalf = new ByHalf();
        byHalf.sort(a);
        System.out.println("\n");
        byHalf.getTime();
        System.out.println("\n");
        byHalf.arraysSort(a);
        System.out.println("\n");
        byHalf.getTime();
        System.out.println("\n");
        byHalf.qsort(a);
        System.out.println("\n");
        byHalf.getTime();
        System.out.println("\n");
        byHalf.reverseSort(a);
        System.out.println("\n");
        byHalf.getTime();
    }
}
