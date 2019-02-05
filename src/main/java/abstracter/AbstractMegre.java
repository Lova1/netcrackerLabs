package abstracter;
import interfaces.Time;

import java.util.Arrays;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @since 1.1
 * <p>
 * This is an main abstract class that include only one abstract method sort
 * </p>
 */
public abstract class AbstractMegre extends AbstractSorter implements Time {

    private long time = 0;
    private long startTime = 0;

    private int[] firstArray;
    private int[] secondArray;

    private int fRange = 0;
    private int sRange = 0;

    @Override
    public double getTime() {
        //System.out.print("Time is " + time);
        return time;
    }

    private void arrPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    protected void merge(int[] inputArray, AbstractSorter abstractSorter){

        if (inputArray.length != 0) {

            startTime = 0;
            startTime = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(inputArray);
            System.out.println("]");

            firstArray = Arrays.copyOfRange(inputArray, 0, inputArray.length / 2);
            secondArray = Arrays.copyOfRange(inputArray, inputArray.length / 2, inputArray.length);

            abstractSorter.sort(firstArray);
            abstractSorter.sort(secondArray);

            doMerge(inputArray, firstArray, secondArray, fRange, sRange);

            if (System.nanoTime() - startTime > 0)
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print(abstractSorter.getClass().getSimpleName() + " Result Array: [ ");
            arrPrint(inputArray);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }

    }

    protected void merge(int[] inputArray, AbstractBubbleSorter abstractBubbleSorter){

        if (inputArray.length != 0) {

            startTime = 0;
            startTime = System.nanoTime();

            System.out.print("Input Array is equal to [ ");
            arrPrint(inputArray);
            System.out.println("]");

            firstArray = Arrays.copyOfRange(inputArray, 0, inputArray.length / 2);
            secondArray = Arrays.copyOfRange(inputArray, inputArray.length / 2, inputArray.length);

            abstractBubbleSorter.reverseSort(firstArray);
            abstractBubbleSorter.reverseSort(secondArray);

            doMerge(inputArray, firstArray, secondArray, fRange, sRange);

            if (System.nanoTime() - startTime > 0)
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print(abstractBubbleSorter.getClass().getSimpleName() + " Result Array: [ ");
            arrPrint(inputArray);
            System.out.println("]");

        } else {
            System.out.println("Array Is Empty");
            startTime = 0;
            return;
        }

    }

    private void doMerge(int[] inputArray, int[] firstArray, int[] secondArray, int fRange, int sRange){

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
