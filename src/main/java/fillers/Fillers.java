package fillers;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @since 1.0
 * @throws NegativeArraySizeException if input value is negative
 * <p>
 * This is an <strong>static</strong> class that create 4 different type of arrays
 *</p>
 */

//todo Create check for non negavite input value
public class Fillers {

    /**
     * Private array that store filled array after one of method has been finished
     */
    private static int[] privateArray;

    /**
     * Set value to privateArray
     * @param arr An input array from one of Fillers method
     */
    private static void setPrivateArray(int[] arr, int arrSize){

        privateArray = new int[arr.length];

        for (int i = 0; i < arrSize; i++)
            privateArray[i] = arr[i];
    }

    /**
     * Set value with the help of Math.random and sort it by Arrays.sort
     * @param arr An input array from one of Fillers method
     * @param arrSize Array size
     */
    private static int[] setAndSortRandValue(int[] arr, int arrSize) {

        for (int i = 1; i < arrSize; i++) {
            arr[i] = (int) Math.round((Math.random() * 300/*fromRenge*/) - 100/*toRange*/);
        }

            Arrays.sort(arr);

        return arr;
    }

    /**
     * This is <strong>static</strong> method that create sorted array
     * that return link for privateArray that contained array with
     * @param arrSize Array size
     */
    public static int[] sort(int arrSize) {

        int[] arr = new int[arrSize];

        setAndSortRandValue(arr,arrSize);

//        System.out.print("Fillers sort [ ");
//        for (int i = 0; i < arrSize; i++)
//            System.out.print(arr[i] + " ");
//        System.out.println("]");

        setPrivateArray(arr, arrSize);
        return privateArray;
    }

    /**
     * This is <strong>static</strong> method that create sorted array with random last element
     * that return link for privateArray that contained array with
     * @param arrSize Array size
     */
    public static int[] randLastElement (int arrSize) {

        int[] arr = new int[arrSize];
        setAndSortRandValue(arr,arrSize);

        Random rand = new Random();
        arr[arrSize-1] = rand.nextInt(50);

//        System.out.print("Fillers randLastElement [ ");
//        for (int i = 0; i < arrSize; i++)
//            System.out.print(arr[i] + " ");
//        System.out.println("]");

        setPrivateArray(arr, arrSize);
        return privateArray;

    }

    /**
     * This is <strong>static</strong> method that create reverse sorted array
     * that return link for privateArray that contained array with
     * @param arrSize Array size
     */
    public static int[] reverseSort (int arrSize) {

        int[] arr = new int[arrSize];
        int[] resultArr = new int[arrSize];
        int plus1 = 0;

        //Arrays.sort(arr, Collections.reverseOrder());
        setAndSortRandValue(arr,arrSize);

        for (int i = arrSize-1; i >= 0; i--) {
            resultArr[plus1] = arr[i];
            plus1++;
        }

//        System.out.print("Fillers reverseSort [ ");
//        for (int i = 0; i < arrSize; i++)
//            System.out.print(resultArr[i] + " ");
//        System.out.println("]");

        setPrivateArray(resultArr, arrSize);
        return privateArray;

    }

    /**
     * This is <strong>static</strong> method that create random array
     * that return link for privateArray that contained array with
     * @param arrSize Array size
     */
    public static int[] randArray(int arrSize){

        int[] arr = new int[arrSize];

        for (int i = 1; i < arrSize; i++) {
            arr[i] = (int) Math.round((Math.random() * 300/*fromRenge*/) - 100/*toRange*/);
        }

//        System.out.print("Fillers randArray [ ");
//        for (int i = 0; i < arrSize; i++)
//            System.out.print(arr[i] + " ");
//        System.out.println("]");

        setPrivateArray(arr, arrSize);
        return privateArray;

    }
}
