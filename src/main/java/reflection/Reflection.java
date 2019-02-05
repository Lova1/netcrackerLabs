package reflection;

import abstracter.AbstractBubbleSorter;
import abstracter.AbstractSorter;
import annotation.MethodFillersAnnotation;
import fillers.Fillers;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Set;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @since 1.1
 * Reflection class include three methods which work with annotations classes
 * and can find super class for any classes
 */
public class Reflection {

    /**
     * Method for finding annotate by MethodFillersAnnotation annotation methods
     * @return {@code annotatedFillers} that is ArrayList which include classes Annotated by MethodFillersAnnotation annotation
     */
    public ArrayList<Method> getFillersAnnotatedMethods() {

        ArrayList<Method> annotatedFillers = new ArrayList<>();

        Class fillerClass = Fillers.class;
        Method[] fillerMethods = fillerClass.getDeclaredMethods();

        for (Method method : fillerMethods) {

            Annotation annotation = method.getAnnotation(MethodFillersAnnotation.class);
            //System.out.println(fillerClass.getClass() + " " + method.getName() + " : " + annotation);

            if (annotation != null) {
                annotatedFillers.add(method);
            }
        }

        return annotatedFillers;
    }

    /**
     * Method for finding classes that extends AbstractSorter
     * @return {@code arraySorters} that is ArrayList which include classes Extends by AbstractSorter class
     */
    public ArrayList getAbstractSorter() {

        ArrayList<AbstractSorter> arraySorters = new ArrayList<>();

        Reflections reflections = new Reflections("sorts");
        Set<Class<? extends AbstractSorter>> subTypes = reflections.getSubTypesOf(AbstractSorter.class);

//        if (!subTypes.isEmpty()) {
//
//            System.out.println("abstractSorterSubTypes.isEmpty = " + subTypes.isEmpty() + "\n");
//            for (Class<? extends AbstractSorter> abstractSorter : subTypes) {
//                System.out.print(abstractSorter.getName() + "\n" /*+ "Superclass :" + abstractSorter.getSuperclass()*/);
//            }
//        }

        for (Class<? extends AbstractSorter> subType : subTypes) {

            if (isSubClassOfAbstractSorter(subType)) {

                try {
                    AbstractSorter sorter = subType.newInstance();
                    arraySorters.add(sorter);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }

        return arraySorters;
    }

    /**
     * Method for finding classes that extends AbstractBubbleSorter
     * @return {@code arraySorters} that is ArrayList which include classes Extends by AbstractBubbleSorter class
     */
    public ArrayList getAbstractBubbleSorter() {

        ArrayList<AbstractBubbleSorter> arraySorters = new ArrayList<>();

        Reflections reflections = new Reflections("sorts");
        Set<Class<? extends AbstractBubbleSorter>> subTypes = reflections.getSubTypesOf(AbstractBubbleSorter.class);

//        if (!subTypes.isEmpty()) {
//
//            System.out.println("abstractSorterSubTypes.isEmpty = " + subTypes.isEmpty() + "\n");
//            for (Class<? extends AbstractSorter> abstractSorter : subTypes) {
//                System.out.print(abstractSorter.getName() + "\n" /*+ "Superclass :" + abstractSorter.getSuperclass()*/);
//            }
//        }

        for (Class<? extends AbstractBubbleSorter> subType : subTypes) {

            if (isSubClassOfAbstractBubbleSorter(subType)) {

                try {
                    AbstractBubbleSorter sorter = subType.newInstance();
                    arraySorters.add(sorter);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }

        return arraySorters;
    }

    public ArrayList getAllSorters(){

        ArrayList<AbstractSorter> aSorters = getAbstractSorter();
        ArrayList<AbstractBubbleSorter> abSorters = getAbstractBubbleSorter();

        ArrayList<AbstractSorter> allSorters = new ArrayList<>();

        if (!aSorters.isEmpty()){
            for (int i = 0; i < aSorters.size(); i++) {
                allSorters.add(aSorters.get(i));
            }
        }

        if (!abSorters.isEmpty()) {
            for (int i = 0; i < abSorters.size(); i++) {
                allSorters.add(abSorters.get(i));
            }
        }

        return allSorters;
    }

    public void printAllSorters(){

        ArrayList arrayList = new ArrayList();
        Reflection reflection = new Reflection();

        if (!reflection.getAllSorters().isEmpty()) {
            for (int i = 0; i < reflection.getAllSorters().size(); i++) {
                arrayList.add(reflection.getAllSorters().get(i));
            }
        }

        if (!reflection.getAllSorters().isEmpty()) {
            for (int i = 0; i < reflection.getAllSorters().size(); i++) {
                System.out.println(arrayList.get(i).getClass().getSimpleName());
            }
        }

    }

    /**
     * <p>
     * Is used in {@link #getAbstractSorter()} to check if the considered method is abstract or not.
     * </p>
     *
     * @param sortClass considered class.
     * @return {@code true}, if the class is not abstract - otherwise it's {@code false}.
     */
    private boolean isSubClassOfAbstractSorter(Class<? extends AbstractSorter> sortClass) {

        int modifier = sortClass.getModifiers();

        return !Modifier.isAbstract(modifier);
    }

    /**
     * <p>
     * Is used in {@link #getAbstractBubbleSorter()} to check if the considered method is abstract or not.
     * </p>
     *
     * @param sortClass considered class.
     * @return {@code true}, if the class is not abstract - otherwise it's {@code false}.
     */
    private boolean isSubClassOfAbstractBubbleSorter(Class<? extends AbstractBubbleSorter> sortClass) {

        int modifier = sortClass.getModifiers();

        return !Modifier.isAbstract(modifier);
    }

    /**
     //     * <p>
     //     *     Used for generating array by calling certain method from {@link Fillers}.
     //     * </p>
     //     * @param fillerMethod method that is needed to be called.
     //     * @param size size of array to generate.
     //     * @return generated array.
     //     */
    public int[] invokeFiller(Method fillerMethod, int size){

        int[] array = new int[size];

        try{
            array = (int[]) fillerMethod.invoke(Fillers.class, size);
        } catch (Exception exc){
            exc.printStackTrace();
        }
        return array;
    }

}

