package byhalf;

import abstractbyhaldsorter.AbstractByHalfSorter;
import bubblesort.BubbleSort;
import myarrays.MyArrays;
import qsort.Qsort;
import timeinterface.Time;
import java.util.Arrays;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @since 1.1
 * @throws NullPointerException if input value is null
 * <p>
 * also this class implements {@link Time#getTime()}
 *</p>
 */

//todo checks for null
public class ByHalf extends AbstractByHalfSorter implements Time {

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

    /**
     * Method that divide input array by two parts and sort it by using {@link BubbleSort#sort(int[])}
     * @see BubbleSort BubbleSort class
     */
    @Override
    public void sort(int[] inputArray) {

        if (inputArray.length != 0) {

            startTime = 0;
            startTime  = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(inputArray);
            System.out.println("]");

            int fRange = 0;
            int sRange = 0;
            int[] finalArr = new int[inputArray.length];

            int[] firstArray;
            int[] secondArray;

            firstArray = Arrays.copyOfRange(inputArray, 0,inputArray.length / 2);
            secondArray = Arrays.copyOfRange(inputArray, inputArray.length/2, inputArray.length);

            BubbleSort bs = new BubbleSort();
            bs.sort(firstArray);
            bs.sort(secondArray);

            int ii = 0;
            while (ii != finalArr.length) {

                if (firstArray.length == fRange) {
                    finalArr[ii] = secondArray[sRange];
                    ii++;
                    sRange++;
                } else if (secondArray.length == sRange) {
                    finalArr[ii] = firstArray[fRange];
                    ii++;
                    fRange++;
                } else if (firstArray[fRange] <= secondArray[sRange]) {
                    finalArr[ii] = firstArray[fRange];
                    fRange++;
                    ii++;
                } else {
                    finalArr[ii] = secondArray[sRange];
                    sRange++;
                    ii++;
                }
            }

            if ( System.nanoTime() - startTime > 0 )
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("sort: [ ");
            arrPrint(finalArr);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }
    }

    /**
     * Method that divide input array by two parts and sort it by using {@link Qsort#sort(int[])}
     * @see Qsort Qsort class
     */
    @Override
    public void qsort(int[] inputArray) {

        if (inputArray.length != 0) {

            startTime = 0;
            startTime  = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(inputArray);
            System.out.println("]");

            int fRange = 0;
            int sRange = 0;
            int[] finalArr = new int[inputArray.length];

            int[] firstArray;
            int[] secondArray;

            firstArray = Arrays.copyOfRange(inputArray, 0,inputArray.length / 2);
            secondArray = Arrays.copyOfRange(inputArray, inputArray.length/2, inputArray.length);

            Qsort qsort= new Qsort();
            qsort.sort(firstArray);
            qsort.sort(secondArray);

            int ii = 0;
            while (ii != finalArr.length) {

                if (firstArray.length == fRange) {
                    finalArr[ii] = secondArray[sRange];
                    ii++;
                    sRange++;
                } else if (secondArray.length == sRange) {
                    finalArr[ii] = firstArray[fRange];
                    ii++;
                    fRange++;
                } else if (firstArray[fRange] <= secondArray[sRange]) {
                    finalArr[ii] = firstArray[fRange];
                    fRange++;
                    ii++;
                } else {
                    finalArr[ii] = secondArray[sRange];
                    sRange++;
                    ii++;
                }
            }

            if ( System.nanoTime() - startTime > 0 )
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("qsort: [ ");
            arrPrint(finalArr);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }
    }

    /**
     * Method that divide input array by two parts and sort it by using {@link MyArrays#sort(int[])}
     * @see MyArrays MyArrays class
     */
    @Override
    public void arraysSort(int[] inputArray) {

        if (inputArray.length != 0) {

            startTime = 0;
            startTime  = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(inputArray);
            System.out.println("]");

            int fRange = 0;
            int sRange = 0;
            int[] finalArr = new int[inputArray.length];

            int[] firstArray;
            int[] secondArray;

            firstArray = Arrays.copyOfRange(inputArray, 0,inputArray.length / 2);
            secondArray = Arrays.copyOfRange(inputArray, inputArray.length/2, inputArray.length);

            MyArrays myArrays = new MyArrays();
            myArrays.sort(firstArray);
            myArrays.sort(secondArray);

            int ii = 0;
            while (ii != finalArr.length) {

                if (firstArray.length == fRange) {
                    finalArr[ii] = secondArray[sRange];
                    ii++;
                    sRange++;
                } else if (secondArray.length == sRange) {
                    finalArr[ii] = firstArray[fRange];
                    ii++;
                    fRange++;
                } else if (firstArray[fRange] <= secondArray[sRange]) {
                    finalArr[ii] = firstArray[fRange];
                    fRange++;
                    ii++;
                } else {
                    finalArr[ii] = secondArray[sRange];
                    sRange++;
                    ii++;
                }
            }

            if ( System.nanoTime() - startTime > 0 )
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("arraysSort: [ ");
            arrPrint(finalArr);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }
    }

    /**
     * Method that divide input array by two parts and sort it by using {@link BubbleSort#sort(int[])}
     * @see BubbleSort BubbleSort class
     */
    @Override
    public void reverseSort(int[] inputArray) {

        if (inputArray.length != 0) {

            startTime = 0;
            startTime  = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(inputArray);
            System.out.println("]");

            int fRange = 0;
            int sRange = 0;
            int[] finalArr = new int[inputArray.length];

            int[] firstArray;
            int[] secondArray;

            firstArray = Arrays.copyOfRange(inputArray, 0,inputArray.length / 2);
            secondArray = Arrays.copyOfRange(inputArray, inputArray.length/2, inputArray.length);

            BubbleSort bs = new BubbleSort();
            bs.reverseSort(firstArray);
            bs.reverseSort(secondArray);

            int ii = 0;
            while (ii != finalArr.length) {

                if (firstArray.length == fRange) {
                    finalArr[ii] = secondArray[sRange];
                    ii++;
                    sRange++;
                } else if (secondArray.length == sRange) {
                    finalArr[ii] = firstArray[fRange];
                    ii++;
                    fRange++;
                } else if (firstArray[fRange] <= secondArray[sRange]) {
                    finalArr[ii] = firstArray[fRange];
                    fRange++;
                    ii++;
                } else {
                    finalArr[ii] = secondArray[sRange];
                    sRange++;
                    ii++;
                }
            }

            if ( System.nanoTime() - startTime > 0 )
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("reverseSort: [ ");
            arrPrint(finalArr);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }
    }
}
