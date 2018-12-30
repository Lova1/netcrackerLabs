package myreflection;

import abstractsorter.AbstractSorter;
import interfacepackage.annotation.ClassFillersAnnotation;
import interfacepackage.annotation.ClassSortAnnotation;
import interfacepackage.annotation.MethodFillersAnnotation;
import interfacepackage.annotation.MethodSortAnnotation;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @since 1.1
 * MyReflection class include three methods which work with annotations classes
 * and can find super class for any classes
 */
public class MyReflection {

    /**
     * Method for finding annotate by MethodSortAnnotation annotation methods
     *
     * @param object Input class References
     */
    public static void getSortAnnotatedMethods(Object object) {

        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(MethodSortAnnotation.class);
            System.out.println(object.getClass() + " " + method.getName() + " : " + annotation);
        }
    }

    /**
     * Method for finding annotate by MethodFillersAnnotation annotation methods
     *
     * @param object Input class References
     */
    public static void getFillersAnnotatedMethods(Object object) {

        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(MethodFillersAnnotation.class);
            System.out.println(object.getClass() + " " + method.getName() + " : " + annotation);
        }
    }

    /**
     * Method for finding SortAnnotatedClasses
     *
     * @param object Input class References
     */
    public static Set getSortAnnotatedClasses(Object object) {

        Class clazz = object.getClass();
        Reflections reflections = new Reflections(clazz);

        //Finds by annotation
        Set<Class<?>> annotateds = reflections.getTypesAnnotatedWith(ClassSortAnnotation.class);

        if (!annotateds.isEmpty()) {

            System.out.println("annotated.isEmpty = " + annotateds.isEmpty());
            for (Class<?> annotated : annotateds) {
                System.out.println(annotated.getName());
            }
        }

        return annotateds;
    }

    /**
     * Method for finding FillerAnnotatedClasses
     *
     * @param object Input class References
     */
    public static Set getFillerAnnotatedClasses(Object object) {

        Class clazz = object.getClass();
        Reflections reflections = new Reflections(clazz);

        Set<Class<?>> annotateds = reflections.getTypesAnnotatedWith(ClassFillersAnnotation.class);

        if (!annotateds.isEmpty()) {

            System.out.println("annotated.isEmpty = " + annotateds.isEmpty());
            for (Class<?> annotated : annotateds) {
                System.out.println(annotated.getName());
            }
        }

        return annotateds;
    }

    /**
     * Method for finding classes that extends AbstractSorter
     *
     * @param object Input class References
     */
    public static Set getClassesExtendsAbstractSorter(Object object) {

        Class clazz = object.getClass();
        Reflections reflections = new Reflections(clazz);

        Set<Class<? extends AbstractSorter>> subTypes = reflections.getSubTypesOf(AbstractSorter.class);

        if (!subTypes.isEmpty()) {

            System.out.println("annotated.isEmpty = " + subTypes.isEmpty());
            for (Class<? extends AbstractSorter> abstractSorter : subTypes) {
                System.out.println(abstractSorter.getName() + "\n" + "Superclass :" + abstractSorter.getSuperclass());
            }
        }

        return subTypes;
    }

}

