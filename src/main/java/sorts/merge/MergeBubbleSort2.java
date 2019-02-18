package sorts.merge;

import abstracter.AbstractMerge;
import abstracter.AbstractSorter;
import sorts.bubblesort.BubbleSort;

public class MergeBubbleSort2 extends AbstractMerge {

    @Override
    public void sort(int[] inputArray) {

        BubbleSort bubbleSort = new BubbleSort();
        merge(inputArray,(AbstractSorter)bubbleSort);


    }
}
