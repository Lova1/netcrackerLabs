package analyzer;

import fillers.Fillers;

import java.util.Map;

public class Analyzer {

    public static void analyze() {

        int as = 10;
        final int[] a;

        a = Fillers.randLastElement(as);

        SortNSizeMap sortNSizeMap = new SortNSizeMap();
        sortNSizeMap.sortRandArray(1_000);
        sortNSizeMap.sortRandLastElementArray(1);
        sortNSizeMap.sortReversArray(10);
        sortNSizeMap.sortSortedArray(100);


        Map<String, Map> generalTimes = sortNSizeMap.getGeneralTimesMap();
        if (!(generalTimes.isEmpty())) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("randArrayMap" + generalTimes.get("randArrayMap"));
            System.out.println("reversArrayMap" + generalTimes.get("reversArrayMap"));
            System.out.println("randLastElementMap" + generalTimes.get("randLastElementMap"));
            System.out.println("sortedMap" + generalTimes.get("sortedMap"));
        }

        //Qsort q = new Qsort();
        //q.sort(a);
        //q.getTime();
        //System.out.println("\n");

        //Reflection.getSortAnnotatedClasses(q);
        //Reflection.getClassesExtendsAbstractSorter(qsort);
        //Reflection.getAnnotatedMethods(q);

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

        */
    }

}

