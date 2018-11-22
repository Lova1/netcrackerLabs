package package04;

import package01.BubbleSort;
import package02.QuicksortSort;
import package03.MyArrays;

import java.util.Arrays;

public class ByHalf {

    private long time = 0;
    private long startTime = 0;

    public void GetTime(){
        System.out.print("Time is " + time);
    }

    private void arrPrint(int[] arr){
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public void halfBubbleFront (int[] ar) {

        if (ar.length != 0) {

            startTime = 0;
            startTime  = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(ar);
            System.out.println("]");

            int fRange = 0;
            int sRange = 0;
            int[] finalArr = new int[ar.length];

            int[] firstArray;
            int[] secondArray;

            firstArray = Arrays.copyOfRange(ar, 0,ar.length / 2);
            secondArray = Arrays.copyOfRange(ar, ar.length/2, ar.length);

            BubbleSort bs = new BubbleSort();
            bs.sortBubbleFromFront(firstArray);
            bs.sortBubbleFromFront(secondArray);

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

            System.out.print("halfBubbleFront: [ ");
            arrPrint(finalArr);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }
    }

    public void halfBubbleEnd(int[] ar) {

        if (ar.length != 0) {

            startTime = 0;
            startTime  = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(ar);
            System.out.println("]");

            int fRange = 0;
            int sRange = 0;
            int[] finalArr = new int[ar.length];

            int[] firstArray;
            int[] secondArray;

            firstArray = Arrays.copyOfRange(ar, 0,ar.length / 2);
            secondArray = Arrays.copyOfRange(ar, ar.length/2, ar.length);

            BubbleSort bs = new BubbleSort();
            bs.sortBubbleFromEnd(firstArray);
            bs.sortBubbleFromEnd(secondArray);

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

            System.out.print("halfBubbleFront: [ ");
            arrPrint(finalArr);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }
    }

    public void halfDoArraysSort(int[] ar) {

        if (ar.length != 0) {

            startTime = 0;
            startTime  = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(ar);
            System.out.println("]");

            int fRange = 0;
            int sRange = 0;
            int[] finalArr = new int[ar.length];

            int[] firstArray;
            int[] secondArray;

            firstArray = Arrays.copyOfRange(ar, 0,ar.length / 2);
            secondArray = Arrays.copyOfRange(ar, ar.length/2, ar.length);

            MyArrays myArrays = new MyArrays();
            myArrays.doArraysSort(firstArray);
            myArrays.doArraysSort(secondArray);

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

            System.out.print("halfDoArraysSort: [ ");
            arrPrint(finalArr);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }
    }

    public void halfDoSort(int[] ar) {

        if (ar.length != 0) {

            startTime = 0;
            startTime  = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(ar);
            System.out.println("]");

            int fRange = 0;
            int sRange = 0;
            int[] finalArr = new int[ar.length];

            int[] firstArray;
            int[] secondArray;

            firstArray = Arrays.copyOfRange(ar, 0,ar.length / 2);
            secondArray = Arrays.copyOfRange(ar, ar.length/2, ar.length);

            QuicksortSort quicksortSort = new QuicksortSort();
            quicksortSort.doQuickSort(firstArray);
            quicksortSort.doQuickSort(secondArray);

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

            System.out.print("halfDoSort: [ ");
            arrPrint(finalArr);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }
    }
}
