package sorts.bubblesort;

import abstracter.AbstractBubbleSorter;
import interfaces.Time;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @throws NullPointerException if input value is null
 * <p>
 * This is an class that extends {@link AbstractBubbleSorter#sort(int[])}
 * also this class implements {@link Time#getTime()}
 * </p>
 * @since 1.1
 */

//todo checks for null
public class BubbleSort extends AbstractBubbleSorter {

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
    public double getTime() {
        //System.out.print("Time is " + time);
        return time;
    }

    /**
     * Output all element
     */
    private synchronized void arrPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /**
     * Method that sort using such algorithm
     * <pre>
     * {@code
     *      if (arr[i] > arr[i + 1])
     *      {
     *          int temp = arr[i + 1];
     *          arr[i + 1] = arr[i];
     *          arr[i] = temp;
     *      }
     * </pre>
     */

    @Override
    public synchronized void sort(int[] inputArray) {

        if (inputArray.length != 0) {

            startTime = 0;
            startTime = System.nanoTime();

            int[] arr = inputArray;

//            System.out.print("Current array from BubbleSort.sort [ ");
//            for (int i = 0; i < inputArray.length; i++)
//                System.out.print(arr[i] + " ");
//
//            System.out.println("]");

            for (int j = 0; j < arr.length - 1; j++) {
                for (int i = 0; i < arr.length - 1; i++) {

                    //todo uncomment for full steps changing in the array
                    //Полностю пошаговый вывод массива на каждом шагу
/*
                    System.out.print("\n");
                    System.out.print("j = " + j + " " + "i = " + i + " " +  "\t" + "arr = ");
                    for (int n = 0; n < ar.length; n++)
                        System.out.print(arr[n] + " ");
*/
                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i + 1];
                        arr[i + 1] = arr[i];
                        arr[i] = temp;

                        //todo uncomment for out steps ONLY WHEN THEY changing in the array
                        //Вывод только если меняется елементы в массиве
                 /*
                    System.out.print("\n" + "j = " + j + " " + "i = " + i + " " +  "\t" + "arr = ");
                    for (int n = 0; n < ar.length; n++)
                        System.out.print(arr[n] + " ");
                    */
                    }
                }
            }

            if (System.nanoTime() - startTime > 0)
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("sort [ ");
            arrPrint(inputArray);
            System.out.println("]");

        } else {

            System.out.println("Array is Empty");
            startTime = 0;
            return;
        }
    }


    /**
     * Method that sort using such algorithm
     * <pre>
     * {@code
     *      if (arr[i] > arr[i - 1])
     *      {
     *          int temp = arr[i - 1];
     *          arr[i - 1] = arr[i];
     *          arr[i] = temp;
     *      }
     * </pre>
     */

    @Override
    public synchronized void reverseSort(int[] inputArray) {

        if (inputArray.length != 0) {

            startTime = 0;
            startTime = System.nanoTime();

            int[] arr = inputArray;

            System.out.print("Current array from BubbleSort.reverseSort [ ");
            for (int i = 0; i < inputArray.length; i++)
                System.out.print(arr[i] + " ");

            System.out.println("]");

            for (int j = arr.length - 1; j > 0; j--) {
                for (int i = arr.length - 1; i > 0; i--) {

                    //todo uncomment for full steps changing in the array
                    //Полностю пошаговый вывод массива на каждом шагу
  /*
                    System.out.print("\n");
                    System.out.print("j = " + j + " " + "i = " + i + " " +  "\t" + "arr = ");
                    for (int n = 0; n < ar.length; n++)
                        System.out.print(arr[n] + " ");

       */
                    if (arr[i] < arr[i - 1]) {
                        int temp = arr[i - 1];
                        arr[i - 1] = arr[i];
                        arr[i] = temp;

                        //todo uncomment for out steps ONLY WHEN THEY changing in the array
                        //Вывод только если меняется елементы в массиве
                 /*
                    System.out.print("\n" + "j = " + j + " " + "i = " + i + " " +  "\t" + "arr = ");
                    for (int n = 0; n < ar.length; n++)
                        System.out.print(arr[n] + " ");
                    */
                    }
                }
            }

            if (System.nanoTime() - startTime > 0)
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("reverseSort [ ");
            arrPrint(inputArray);
            System.out.println("]");

        } else {

            System.out.print("Array is Empty");
            startTime = 0;
            return;
        }
    }

}
