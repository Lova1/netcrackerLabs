/*
package analyzer;


import fillers.Fillers;
import package01.BubbleSort;
import package02.QuicksortSort;
import package03.MyArrays;
import package04.ByHalf;

public class Analyzer {

    private  int arrSize = 10;
    private int[] arr;

    private BubbleSort bubbleSort = new BubbleSort();
    private QuicksortSort quicksortSort = new QuicksortSort();
    private MyArrays myArrays = new MyArrays();
    private ByHalf byHalf = new ByHalf();
    private Fillers fil = new Fillers();

    private void allMethods(Fillers fil){

        arr = fil.write();
        bubbleSort.sortBubbleFromFront(arr);
        bubbleSort.GetTime();
        System.out.println("\n\n--------------------\n");

        arr = fil.write();
        bubbleSort.sortBubbleFromEnd(arr);
        bubbleSort.GetTime();
        System.out.println("\n\n--------------------\n");

        arr = fil.write();
        quicksortSort.doQuickSort(arr);
        quicksortSort.GetTime();
        System.out.println("\n\n--------------------\n");

        arr = fil.write();
        myArrays.doArraysSort(arr);
        myArrays.GetTime();
        System.out.println("\n\n--------------------\n");

        arr = fil.write();
        byHalf.halfBubbleFront(arr);
        byHalf.GetTime();
        System.out.println("\n\n--------------------\n");

        arr = fil.write();
        byHalf.halfBubbleEnd(arr);
        byHalf.GetTime();
        System.out.println("\n\n--------------------\n");

        arr = fil.write();
        byHalf.halfDoSort(arr);
        byHalf.GetTime();
        System.out.println("\n\n--------------------\n");

        arr = fil.write();
        byHalf.halfDoArraysSort(arr);
        byHalf.GetTime();
        System.out.println("\n\n--------------------");

    }

    public void analyze(){

        System.out.println("\n\t Fillers.randArray \n");

        fil.randArray(arrSize);
        allMethods(fil);

        System.out.println("\n\t Fillers.randLastElement \n");

        fil.randLastElement(arrSize);
        allMethods(fil);

        System.out.println("\n\t Fillers.reverseSort \n");

        fil.reverseSort(arrSize);
        allMethods(fil);

        System.out.println("\n\t Fillers.sort \n");

        fil.sort(arrSize);
        allMethods(fil);

    }
}
*/
