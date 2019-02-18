/*

package sorts.merge;

import abstracter.AbstractSorter;
import sorts.bubblesort.BubbleSort;
import interfaces.Time;
import java.util.Arrays;




*/
/**
 * @author Lova Vardanian
 * @version 1.1
 * @throws NullPointerException if input value is null
 * <p>
 * also this class implements {@link Time#getTime()}
 * </p>
 * @since 1.1
 *//*




//todo checks for null
public class MergeBubblesort extends AbstractSorter implements Runnable{



*/
/**
     * @param time is parameter that save time of method that has been started/stopped
     * @param startTime is parameter for start time when method has been started
     * @param firstArray is first array for save subarray from input array
     * @param secondArray is second array for save subarray from input array
     * @param fRange is counter for fist subarray
     * @param sRange is counter for second subarray
     *//*



    private long time = 0;
    private long startTime = 0;

    private int[] firstArray;
    private int[] secondArray;

    private int fRange = 0;
    private int sRange = 0;

    private int[] iArray;



*/
/**
     * Return measured time
     *//*



    @Override
    public synchronized double getTime() {
        //System.out.print("Time is " + time);
        return time;
    }

    // Default Constructor
    public MergeBubblesort(){}

    // Constructor for multithreading
    public MergeBubblesort(int[] inputArray){
        iArray = inputArray;
    }

    @Override
    public void run(){

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        sort(iArray);
        System.out.println(Thread.currentThread().getName());
        System.out.println("MergeBubblesort Time " + getTime());

    }



*/
/**
     * Output all element
     *//*



    private synchronized void arrPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }



*/
/**
     * Method that divide input array by two parts and sort it by using {@link BubbleSort#sort(int[])}
     *
     * @see BubbleSort BubbleSort class
     *//*



    @Override
    public synchronized void sort(int[] inputArray) {

        if (inputArray.length != 0) {

            startTime = 0;
            startTime = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(inputArray);
            System.out.println("]");

            firstArray = Arrays.copyOfRange(inputArray, 0, inputArray.length / 2);
            secondArray = Arrays.copyOfRange(inputArray, inputArray.length / 2, inputArray.length);

            BubbleSort bs = new BubbleSort();
            bs.sort(firstArray);
            bs.sort(secondArray);

            doMerge(inputArray, firstArray, secondArray, fRange, sRange);

            if (System.nanoTime() - startTime > 0)
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            synchronized (this) {
                System.out.print("MergeBubblesort.sort Result Array: [ ");
                arrPrint(inputArray);
                System.out.println("]");
            }

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }
    }

    private synchronized static void doMerge(int[] inputArray, int[] firstArray, int[] secondArray, int fRange, int sRange) {

        int ii = 0;
        while (ii != inputArray.length) {

            if (firstArray.length == fRange) {
                inputArray[ii] = secondArray[sRange];
                ii++;
                sRange++;
            } else if (secondArray.length == sRange) {
                inputArray[ii] = firstArray[fRange];
                ii++;
                fRange++;
            } else if (firstArray[fRange] <= secondArray[sRange]) {
                inputArray[ii] = firstArray[fRange];
                fRange++;
                ii++;
            } else {
                inputArray[ii] = secondArray[sRange];
                sRange++;
                ii++;
            }
        }

    }

}
*/
