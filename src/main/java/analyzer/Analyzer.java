package analyzer;

import abstractsorter.AbstractSorter;
import fillers.Fillers;
import myreflection.MyReflection;
import sorts.bubblesort.BubbleSort;
import sorts.byhalf.ByHalf;
import sorts.qsort.Qsort;

public class Analyzer {

    public static void analyze(){

        int as = 10;
        final int[] a;

        //a = Fillers.randLastElement(as);

        BubbleSort q = new BubbleSort();
        //q.sort(a);
        //q.getTime();
        //System.out.println("\n");

        MyReflection.getSuperClass(q);
        //MyReflection.getAnnotatedMethods(q);

/*
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
        byHalf.getTime();*/
    }
}

