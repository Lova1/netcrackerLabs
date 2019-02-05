package sorts.merge;

import abstracter.AbstractMegre;
import sorts.bubblesort.BubbleSort;

public class MergeBubbleSort2 extends AbstractMegre {

    @Override
    public void sort(int[] inputArray) {

        BubbleSort bubbleSort = new BubbleSort();
        merge(inputArray,bubbleSort);

    }
}
