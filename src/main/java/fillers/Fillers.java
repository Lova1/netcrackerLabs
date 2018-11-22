package baselab01.fillers;

import baselab01.package01.BubbleSort;
import java.lang.Exception;
import java.util.Arrays;
import java.util.Random;

public class Fillers {

    private int[] privateArray;

    private void setPrivateArray(int[] arr, int arrSize){

        privateArray = new int[arr.length];

        for (int i = 0; i < arrSize; i++)
            privateArray[i] = arr[i];
    }

    private int[] setAndSortRandValue(int[] arr, int arrSize) {

        for (int i = 1; i < arrSize; i++) {
            arr[i] = (int) Math.round((Math.random() * 300/*fromRenge*/) - 100/*toRange*/);
        }

//        BubbleSort bs = new BubbleSort();
//        bs.sortBubbleFromFront(arr);
            Arrays.sort(arr);

        return arr;
    }

    // todo Make range for taking range parameters
    public void sort(int arrSize /*, int fromRenge, int toRange*/) /*throws Exception*/ {
/*

        if (fromRenge > toRange)
            throw new Exception("fromRenge can not be > than toRange");
*/

        int[] arr = new int[arrSize];

        setAndSortRandValue(arr,arrSize);

        System.out.print("Fillers sort [ ");
        for (int i = 0; i < arrSize; i++)
            System.out.print(arr[i] + " ");
        System.out.println("]");

        setPrivateArray(arr, arrSize);
    }

    public void randLastElement (int arrSize) {

        int[] arr = new int[arrSize];
        setAndSortRandValue(arr,arrSize);

        Random rand = new Random();
        arr[arrSize-1] = rand.nextInt(50);

        System.out.print("Fillers randLastElement [ ");
        for (int i = 0; i < arrSize; i++)
            System.out.print(arr[i] + " ");
        System.out.println("]");

        setPrivateArray(arr, arrSize);

    }

    public void reverseSort (int arrSize) {

        int[] arr = new int[arrSize];
        int[] resultArr = new int[arrSize];
        int plus1 = 0;

        //Arrays.sort(arr, Collections.reverseOrder());
        setAndSortRandValue(arr,arrSize);

        for (int i = arrSize-1; i >= 0; i--) {
            resultArr[plus1] = arr[i];
            plus1++;
        }

        System.out.print("Fillers reverseSort [ ");
        for (int i = 0; i < arrSize; i++)
            System.out.print(resultArr[i] + " ");
        System.out.println("]");

        setPrivateArray(arr, arrSize);

    }

    public void randArray(int arrSize){

        int[] arr = new int[arrSize];

        for (int i = 1; i < arrSize; i++) {
            arr[i] = (int) Math.round((Math.random() * 300/*fromRenge*/) - 100/*toRange*/);
        }

        setPrivateArray(arr, arrSize);

    }

    public int[] write() {

        int[] writeToArray;
        writeToArray = Arrays.copyOf(privateArray, privateArray.length);

        return writeToArray;
    }
}
