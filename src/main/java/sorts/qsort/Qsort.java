package sorts.qsort;

import abstractsorter.AbstractSorter;
import interfaces.Time;

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
public class Qsort extends AbstractSorter {

    /**
     * @param time Parameter that save time of method that has been started/stopped
     * @param startTime Parameter for start time when method has been started
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
    private void arrPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /**
     * Method that sort by calling isort method that include the main logic of sort
     */
    @Override
    public void sort(int[] inputArray) {

        if (inputArray.length > 0) {

            startTime = 0;
            startTime = System.nanoTime();

            int low = 0;
            int high = inputArray.length - 1;
            isort(inputArray, low, high);

            if (System.nanoTime() - startTime > 0)
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("qsort [ ");
            arrPrint(inputArray);
            System.out.println("]");
        } else {
            System.out.print("Array is Empty");
            startTime = 0;
            return;
        }
    }

    /**
     * Method that sort by calling recursion if low < high
     *
     * @param low  Is the right part of subarray
     * @param high Is the left part of subarray
     */
    int[] isort(int[] arr, int low, int high) {

        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            isort(arr, low, pi - 1);
            isort(arr, pi + 1, high);
        }
        return arr;
    }

    /**
     * Method that work with partition element by setting pivot element and swap array elements
     *
     * @param arr Input array
     */
    int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {

                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
