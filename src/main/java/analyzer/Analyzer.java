package analyzer;

import fillers.Fillers;
import myreflection.MyReflection;
import sorts.byhalf.ByHalf;
import sorts.qsort.Qsort;

public class Analyzer {

    public static void analyze() {

        int as = 10;
        final int[] a;

        a = Fillers.randLastElement(as);

        Qsort q = new Qsort();
        //q.sort(a);
        //q.getTime();
        //System.out.println("\n");

        ByHalf qsort = new ByHalf();
        qsort.qsort(a);

        //MyReflection.getSortAnnotatedClasses(q);
        MyReflection.getClassesExtendsAbstractSorter(qsort);
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

