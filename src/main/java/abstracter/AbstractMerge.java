package abstracter;

import interfaces.Time;
import sorts.merge.MergeThread;

import java.util.*;
import java.util.concurrent.*;

public abstract class AbstractMerge extends AbstractSorter implements Time {

    private long time = 0;
    private long startTime = 0;

    private int[] subArray;

    private int from = 0;
    private int to;
    private int availableProcessors = Runtime.getRuntime().availableProcessors();

    @Override
    public double getTime() {
        //System.out.print("Time is " + time);
        return time;
    }

    private void arrPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

    }


    protected void merge(int[] inputArray, AbstractSorter sorterA) {

        if (inputArray.length != 0) {

            startTime = 0;
            startTime = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(inputArray);
            System.out.println("]");

            Queue<int[]> arrayParts = getSubArrayParts(inputArray);
            ExecutorService executor = Executors.newFixedThreadPool(availableProcessors);
            List<Future<int[]>> futures = new ArrayList<>();

            for(int i = 0; i < availableProcessors; i++){
                Future<int[]> future = executor.submit(new MergeThread(arrayParts.remove(), sorterA));
                futures.add(future);
            }

            int[] leftArray = {};

            for(Future<int[]> future : futures){
                try {

                    int[] rightArray = future.get();

                    doMerge(inputArray,leftArray, rightArray);

                    leftArray = Arrays.copyOfRange(inputArray, 0, rightArray.length + leftArray.length);;

                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            executor.shutdown();

            if (System.nanoTime() - startTime > 0)
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print(sorterA.getClass().getSimpleName() + " Result Array: [ ");
            arrPrint(inputArray);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty\n");
            startTime = 0;
            return;
        }

    }

    protected void merge(int[] inputArray, AbstractBubbleSorter sorterAB) {

        if (inputArray.length != 0) {

            startTime = 0;
            startTime = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(inputArray);
            System.out.println("]");

            Queue<int[]> arrayParts = getSubArrayParts(inputArray);
            ExecutorService executor = Executors.newFixedThreadPool(availableProcessors);
            List<Future<int[]>> futures = new ArrayList<>();

            for(int i = 0; i < availableProcessors; i++){
                Future<int[]> future = executor.submit(new MergeThread(arrayParts.remove(), sorterAB));
                futures.add(future);
            }

            int[] leftArray = {};

            for(Future<int[]> future : futures){
                try {

                    int[] rightArray = future.get();

                    doMerge(inputArray,leftArray, rightArray);

                    leftArray = Arrays.copyOfRange(inputArray, 0, rightArray.length + leftArray.length);;

                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            executor.shutdown();

            if (System.nanoTime() - startTime > 0)
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print(sorterAB.getClass().getSimpleName() + " Result Array: [ ");
            arrPrint(inputArray);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty\n");
            startTime = 0;
            return;
        }
    }

    private Queue<int[]> getSubArrayParts(int[] inputArray){

        Queue<int[]> arrayParts = new LinkedList<>();

        for (int iter = 1; iter <= availableProcessors; iter++) {

            System.out.println("\n" + "-----------------");

            to = (inputArray.length / availableProcessors) * iter;

            if (iter == availableProcessors)
                to = inputArray.length;

            subArray = Arrays.copyOfRange(inputArray, from, to);

            from = to;

            for (int i = 0; i < subArray.length; i++) {
                System.out.println("This is " + i + " value = " + subArray[i]);
            }

            System.out.println(subArray.length);

            arrayParts.add(subArray);
        }

        return arrayParts;
    }

    private void doMerge(int[] inputArray, int[] leftArray, int[] rightArray) {

        int ii = 0;
        int leftRange = 0;
        int rightRange = 0;

        while (ii != (leftArray.length + rightArray.length)) {

            if (leftArray.length == leftRange) {
                inputArray[ii] = rightArray[rightRange];
                ii++;
                rightRange++;
            } else if (rightArray.length == rightRange) {
                inputArray[ii] = leftArray[leftRange];
                ii++;
                leftRange++;
            } else if (leftArray[leftRange] <= rightArray[rightRange]) {
                inputArray[ii] = leftArray[leftRange];
                leftRange++;
                ii++;
            } else {
                inputArray[ii] = rightArray[rightRange];
                rightRange++;
                ii++;
            }
        }
    }
}
