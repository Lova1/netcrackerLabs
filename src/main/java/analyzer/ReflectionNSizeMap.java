package analyzer;

import abstracter.AbstractBubbleSorter;
import abstracter.AbstractSorter;
import reflection.Reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReflectionNSizeMap {

    private static Map<String, Map<String, Double>> getSortMap(int ArrFillSize) {

        Map<String, Map<String, Double>> sortMap = new HashMap<>();
        Map<String, Double> fillerMap;

        int[] iarr;

        Reflection reflection = new Reflection();

        ArrayList<AbstractSorter> aList = reflection.getAbstractSorter();
        ArrayList<AbstractBubbleSorter> abList  = reflection.getAbstractBubbleSorter();

        ArrayList<Method> fiMethods = reflection.getFillersAnnotatedMethods();


        for (AbstractSorter absClass : aList) {

           fillerMap = new HashMap<>();

            for (Method fillersMethod : fiMethods) {

                iarr = reflection.invokeFiller(fillersMethod, ArrFillSize);

                absClass.sort(iarr);

                Double time = absClass.getTime();

                fillerMap.put(fillersMethod.getName(), time);
            }
            sortMap.put(absClass.getClass().getSimpleName(), fillerMap);
        }

        for (AbstractBubbleSorter absClass : abList) {

            fillerMap = new HashMap<>();

            for (Method fillersMethod : fiMethods) {

                iarr = reflection.invokeFiller(fillersMethod, ArrFillSize);

                absClass.reverseSort(iarr);

                Double time = absClass.getTime();

                fillerMap.put(fillersMethod.getName(), time);
            }
            sortMap.put(absClass.getClass().getSimpleName() + "Reverse", fillerMap);
        }

        return sortMap;
    }

    public static   Map<String, Map<String, Map<String, Double>>> getNSizeSortMap(int upToSize) {

        Map<String, Map<String, Map<String, Double>>> nSizeSortMap = new HashMap<>();

        for (int i = 1; i <= upToSize; i = i * 10){
            nSizeSortMap.put(String.valueOf(i),getSortMap(i));
        }

        return nSizeSortMap;
    }
}
