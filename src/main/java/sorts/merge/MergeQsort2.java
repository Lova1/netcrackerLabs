package sorts.merge;

import abstracter.AbstractMerge;
import sorts.qsort.Qsort;

public class MergeQsort2 extends AbstractMerge {

    @Override
    public void sort(int[] inputArray) {

        Qsort qsort = new Qsort();
        merge(inputArray,qsort);

    }

}
