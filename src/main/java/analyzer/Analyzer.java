package analyzer;

import fillers.Fillers;
import sorts.bubblesort.BubbleSort;
import sorts.byhalf.ByHalf;
import sorts.qsort.Qsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Analyzer {

    public static void analyze() {

        int as = 10;
        final int[] a;

        a = Fillers.randLastElement(as);

        SortNSizeArray sortNSizeArray = new SortNSizeArray();
        sortNSizeArray.sortRandArray(1_000);
        sortNSizeArray.sortRandLastElementArray(1);
        sortNSizeArray.sortReversArray(10);
        sortNSizeArray.sortSortedArray(100);


        Map<String, Map> generalTimes = sortNSizeArray.getGeneralTimesMap();
        if (!(generalTimes.isEmpty())) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("generalTimesMap" + generalTimes.get("randArrayMap"));
            System.out.println("reversArrayMap" + generalTimes.get("reversArrayMap"));
            System.out.println("randLastElementMap" + generalTimes.get("randLastElementMap"));
            System.out.println("sortedMap" + generalTimes.get("sortedMap"));
        }

        //Qsort q = new Qsort();
        //q.sort(a);
        //q.getTime();
        //System.out.println("\n");

        //MyReflection.getSortAnnotatedClasses(q);
        //MyReflection.getClassesExtendsAbstractSorter(qsort);
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

