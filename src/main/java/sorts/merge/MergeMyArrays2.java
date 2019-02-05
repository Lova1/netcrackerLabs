package sorts.merge;

import abstracter.AbstractMegre;
import sorts.myarrays.MyArrays;

public class MergeMyArrays2 extends AbstractMegre {

    @Override
    public void sort(int[] inputArray) {

        MyArrays myArrays = new MyArrays();
        merge(inputArray,myArrays);

    }
}
