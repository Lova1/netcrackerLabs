package sorts.merge;

import abstracter.AbstractBubbleSorter;
import abstracter.AbstractMerge;
import sorts.bubblesort.BubbleSort;

public class MergeReverseBubbleSort2 extends AbstractMerge {

    @Override
    public void sort(int[] inputArray) {

        BubbleSort bubbleSort = new BubbleSort();
        merge(inputArray,bubbleSort);

    }
}
