package myreflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @since 1.1
 * MyReflection class include three methods which work with annotations classes
 * and can find super class for any classes
 */
public class MyReflection {

    /**
     *Method for finding annotate methods
     * @param object Input class References
     */
    public static void getAnnotatedMethods (Object object) {

        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
               // Annotation msa = method.getAnnotation(MethodSortAnnotation.class);
               //       if(annotation.equals(msa))
                System.out.println(object.getClass() + " " + method.getName() + " : " + annotation);
            }
        }
    }

    /**
     *Method for finding annotate class
     * @param object Input class References
     */
    public static void getAnnotatedClass (Object object) {

        Class clazz = object.getClass();
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println(clazz + " : " + annotations);
    }

    /**
     *Method for finding SuperClass
     * @param object Input class References
     */
    public static void getSuperClass (Object object) {

        Class clazz = object.getClass();
        Class sclass = clazz.getSuperclass();
        System.out.println(sclass.toString());
    }


}

