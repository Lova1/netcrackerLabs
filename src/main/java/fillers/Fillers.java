package fillers;

import interfacepackage.annotation.ClassFillersAnnotation;
import interfacepackage.annotation.MethodFillersAnnotation;

import java.util.Random;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @since 1.0
 * <p>
 * This is an <strong>static</strong> class that create 4 different type of arrays
 * </p>
 */
@ClassFillersAnnotation
public class Fillers {

    /**
     * Private array that store filled array after one of method has been finished
     */
    private static int[] privateArray;

    /**
     * Set value to privateArray
     *
     * @param arr An input array from one of Fillers method
     */
    private static void setPrivateArray(int[] arr, int arrSize) {

        privateArray = new int[arr.length];

        for (int i = 0; i < arrSize; i++)
            privateArray[i] = arr[i];
    }

    /**
     * Set value with the help of Math.random and sort it by Arrays.sort
     *
     * @param arr     An input array from one of Fillers method
     * @param arrSize Array size
     */

    private static int[] setAndSortRandValue(int[] arr, int arrSize) {

        int checker;
        final int FROM_POSITIVE_RANGE = 300;
        final int FROM_NEGATIVE_RANDE = 100;

        arr[0] = (int) Math.round((Math.random() * FROM_POSITIVE_RANGE) - FROM_NEGATIVE_RANDE);

        for (int i = 1; i < arrSize; i++) {

            checker = (int) Math.round((Math.random() * FROM_POSITIVE_RANGE) - FROM_NEGATIVE_RANDE);

            if (checker > 0)
                arr[i] = arr[i - 1] + checker;
            else
                arr[i] = arr[i - 1] - checker;
        }
        return arr;
    }

    /**
     * This is <strong>static</strong> method that create sorted array
     * that return link for privateArray that contained array with
     *
     * @param arrSize Array size
     */

    @MethodFillersAnnotation
    public static int[] sort(int arrSize) {

        if (arrSize > 0) {
            int[] arr = new int[arrSize];

            setAndSortRandValue(arr, arrSize);

//            System.out.print("Fillers sort [ ");
//            for (int i = 0; i < arrSize; i++)
//                System.out.print(arr[i] + " ");
//            System.out.println("]");

            setPrivateArray(arr, arrSize);
            return privateArray;
        } else {
            System.out.println("Array size should be greater than 0");
            return new int[0];
        }
    }

    /**
     * This is <strong>static</strong> method that create sorted array with random last element
     * that return link for privateArray that contained array with
     *
     * @param arrSize Array size
     */
    @MethodFillersAnnotation
    public static int[] randLastElement(int arrSize) {

        if (arrSize > 0) {
            int[] arr = new int[arrSize];
            setAndSortRandValue(arr, arrSize);

            Random rand = new Random();
            arr[arrSize - 1] = rand.nextInt(50);

//            System.out.print("Fillers randLastElement [ ");
//            for (int i = 0; i < arrSize; i++)
//                System.out.print(arr[i] + " ");
//            System.out.println("]");

            setPrivateArray(arr, arrSize);
            return privateArray;
        } else {
            System.out.println("Array size should be greater than 0");
            return new int[0];
        }

    }

    /**
     * This is <strong>static</strong> method that create reverse sorted array
     * that return link for privateArray that contained array with
     *
     * @param arrSize Array size
     */
    @MethodFillersAnnotation
    public static int[] reverseSort(int arrSize) {

        if (arrSize > 0) {
            int[] arr = new int[arrSize];
            int[] resultArr = new int[arrSize];
            int plus1 = 0;

//            Arrays.sort(arr, Collections.reverseOrder());
            setAndSortRandValue(arr, arrSize);

            for (int i = arrSize - 1; i >= 0; i--) {
                resultArr[plus1] = arr[i];
                plus1++;
            }

//            System.out.print("Fillers reverseSort [ ");
//            for (int i = 0; i < arrSize; i++)
//                System.out.print(resultArr[i] + " ");
//            System.out.println("]");

            setPrivateArray(resultArr, arrSize);
            return privateArray;
        } else {
            System.out.println("Array size should be greater than 0");
            return new int[0];
        }

    }

    /**
     * This is <strong>static</strong> method that create random array
     * that return link for privateArray that contained array with
     *
     * @param arrSize Array size
     */
    @MethodFillersAnnotation
    public static int[] randArray(int arrSize) {

        if (arrSize > 0) {
            int[] arr = new int[arrSize];

            for (int i = 1; i < arrSize; i++) {
                arr[i] = (int) Math.round((Math.random() * 300/*fromRenge*/) - 100/*toRange*/);
            }

//            System.out.print("Fillers randArray [ ");
//            for (int i = 0; i < arrSize; i++)
//                System.out.print(arr[i] + " ");
//            System.out.println("]");

            setPrivateArray(arr, arrSize);
            return privateArray;
        } else {
            System.out.println("Array size should be greater than 0");
            return new int[0];
        }
    }
}
