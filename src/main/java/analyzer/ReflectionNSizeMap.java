package analyzer;

import abstractsorter.AbstractSorter;
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

        ArrayList<AbstractSorter> classList = reflection.getClassesExtendsAbstractSorter();
        ArrayList<Method> fiMethods = reflection.getFillersAnnotatedMethods();


        for (AbstractSorter absClass : classList) {

           fillerMap = new HashMap<>();

            for (Method fillersMethod : fiMethods) {

                iarr = reflection.invokeFiller(fillersMethod, ArrFillSize);

                absClass.sort(iarr);

                Double time = absClass.getTime();

                fillerMap.put(fillersMethod.getName(), time);
            }
            sortMap.put(absClass.getClass().getSimpleName(), fillerMap);
        }
        return sortMap;
    }

    public static Map<String, Map<String, Map<String, Double>>> getNSizeSortMap(int upToSize) {

        Map<String, Map<String, Map<String, Double>>> nSizeSortMap = new HashMap<>();

        for (int i = 1; i <= upToSize; i = i * 10){
            nSizeSortMap.put(String.valueOf(i),getSortMap(i));
        }

        return nSizeSortMap;
    }
}
