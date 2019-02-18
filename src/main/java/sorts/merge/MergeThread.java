package sorts.merge;

import abstracter.AbstractBubbleSorter;
import abstracter.AbstractSorter;

import java.util.concurrent.Callable;

public class MergeThread implements Callable<int[]> {

    private AbstractSorter sorterA;
    private AbstractBubbleSorter sorterAB;
    private int[] array;

    public MergeThread(int[] array, AbstractSorter sorterA) {
        this.array = array;
        this.sorterA = sorterA;
    }

    public MergeThread(int[] array, AbstractBubbleSorter sorterAB) {
        this.array = array;
        this.sorterAB = sorterAB;
    }

    @Override
    public int[] call() {

        if (sorterA != null)
            sorterA.sort(array);
        else
            sorterAB.reverseSort(array);

        return this.array;
    }
}
