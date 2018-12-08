package sorts.myarrays;

import abstractsorter.AbstractSorter;
import interfacepackage.annotation.ClassSortAnnotation;
import interfacepackage.annotation.MethodSortAnnotation;
import timeinterface.Time;

import java.util.Arrays;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @throws NullPointerException if input value is null
 * <p>
 * This is an class that extends {@link AbstractSorter#sort(int[])}
 * also this class implements {@link Time#getTime()}
 * </p>
 * @since 1.1
 */

//todo checks for null
@ClassSortAnnotation
public class MyArrays extends AbstractSorter implements Time {

    /**
     * @param time is parameter that save time of method that has been started/stopped
     * @param startTime is parameter for start time when method has been started
     */
    protected long time = 0;
    protected long startTime = 0;

    /**
     * Return measured time
     */
    @Override
    public void getTime() {
        System.out.print("Time is " + time);
    }

    /**
     * Output all element
     */
    private void arrPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    //todo @see java.util.Arrays java.util.Arrays to not create the link

    /**
     * Method that sort by calling Array.sort method from java.util.Arrays.sort package
     *
     * @see java.util.Arrays java.util.Arrays
     */

    @Override
    @MethodSortAnnotation
    public void sort(int[] inputArray) {

        if (inputArray.length != 0) {

            startTime = 0;
            startTime = System.nanoTime();

            System.out.print("Current array [ ");
            arrPrint(inputArray);
            System.out.println("]");

            Arrays.sort(inputArray);

            if (System.nanoTime() - startTime > 0)
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("MyArrays.sort [ ");
            arrPrint(inputArray);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }
    }
}
