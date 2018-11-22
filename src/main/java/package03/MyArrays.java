package package03;

import java.util.Arrays;

public class MyArrays {

    private long time = 0;
    private long startTime = 0;

    public void GetTime(){
        System.out.print("Time is " + time);
    }

    private void arrPrint(int[] arr){
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public void doArraysSort(int[] ar) {

        if (ar.length != 0) {

            startTime = 0;
            startTime  = System.nanoTime();

            System.out.print("Current array [ ");
            arrPrint(ar);
            System.out.println("]");

            Arrays.sort(ar);

            if ( System.nanoTime() - startTime > 0 )
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("MyArrays.doArraysSort [ ");
            arrPrint(ar);
            System.out.println("]");

        }else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }
    }

}
