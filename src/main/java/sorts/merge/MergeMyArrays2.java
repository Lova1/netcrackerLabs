package sorts.merge;

import abstracter.AbstractMerge;
import sorts.myarrays.MyArrays;

public class MergeMyArrays2 extends AbstractMerge {

    @Override
    public void sort(int[] inputArray) {

        MyArrays myArrays = new MyArrays();
        merge(inputArray,myArrays);

    }
}
