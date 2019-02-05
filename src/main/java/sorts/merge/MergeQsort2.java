package sorts.merge;

import abstracter.AbstractMegre;
import sorts.qsort.Qsort;

public class MergeQsort2 extends AbstractMegre {

    @Override
    public void sort(int[] inputArray) {

        Qsort qsort = new Qsort();
        merge(inputArray,qsort);

    }

}
