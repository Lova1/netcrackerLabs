package baselab01.output;

import baselab01.fillers.Fillers;
import baselab01.package01.BubbleSort;
import baselab01.package03.MyArrays;
import baselab01.package04.ByHalf;
import baselab01.package02.QuicksortSort;

public class OutputResult {

    public void output() {

        int arrSize = 10;
        int[] ar;

            System.out.print("\n");
            System.out.print("Запуск Class Fillers.......\n\n");
        // todo не копирует значения елементов а копирует ссылку
        Fillers fl = new Fillers();
        fl.randArray(arrSize);
        ar = fl.write();

                System.out.println("\tЗапуск randArray.......");
            fl.randArray(arrSize);
        System.out.print("Fillers randArray [ ");
        for (int i = 0; i < ar.length; i++) {
            ar = fl.write();
            System.out.print(ar[i] + " ");
        }
        System.out.print("]");

                System.out.print("\n\n");
                System.out.println("\tЗапуск randLastElement.......");
            fl.randLastElement(arrSize);

                System.out.print("\n");
                System.out.println("\tЗапуск reverseSort.......");
            fl.reverseSort(arrSize);

                System.out.print("\n");
                System.out.println("\tЗапуск sort.......");
            fl.sort(arrSize);

        System.out.print("\n");
        System.out.println("------------------------------------------------------------------");

        fl.randArray(arrSize);
        ar = fl.write();

        // тестирование всех методов их всех классов

            System.out.print("\n");
            System.out.print("Запуск Class BubbleSort.......\n\n");
        BubbleSort bs = new BubbleSort();
            System.out.println("\tЗапуск BubbleSort.sortBubbleFromFront.......");
        bs.sortBubbleFromFront(ar);

        fl.randArray(arrSize);
        ar = fl.write();

            System.out.print("\n\n");
            System.out.println("\tЗапуск BubbleSort.sortBubbleFromEnd.......");
        bs.sortBubbleFromEnd(ar);

        fl.randArray(arrSize);
        ar = fl.write();

            System.out.print("\n");
            System.out.println("------------------------------------------------------------------");
            System.out.print("\n");
            System.out.println("Запуск Class MyArrays.......\n");
        MyArrays myArrays = new MyArrays();
            System.out.println("\tЗапуск MyArrays.doArraysSort.......\n");
        myArrays.doArraysSort(ar);
            System.out.println("\n");
            System.out.println("------------------------------------------------------------------");
            System.out.print("\n");
            System.out.println("Запуск Class QuicksortSort.......\n");
        QuicksortSort qs = new QuicksortSort();
            System.out.println("\tЗапуск QuicksortSort.doSort.......\n");
        qs.doQuickSort(ar);
            System.out.print("\n");
            System.out.println("------------------------------------------------------------------");
            System.out.print("\n");
            System.out.println("Запуск Class ByHalf.......\n");
        ByHalf bh = new ByHalf();
            System.out.println("\tЗапуск ByHalf.halfBubbleFront.......\n");
        bh.halfBubbleFront(ar);
            System.out.print("\n");
            System.out.println("\tЗапуск ByHalf.halfBubbleEnd.......\n");
        bh.halfBubbleEnd(ar);
            System.out.print("\n");
            System.out.println("\tЗапуск ByHalf.halfDoArraysSort.......\n");
        bh.halfDoArraysSort(ar);
            System.out.print("\n");
            System.out.println("\tЗапуск ByHalf.halfDoSort.......\n");
        bh.halfDoSort(ar);
            System.out.print("\n");
            System.out.println("------------------------------------------------------------------");
    }
}
