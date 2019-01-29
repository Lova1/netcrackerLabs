package sorts.multithread;

import sorts.merge.MergeBubblesort;

public class ThreadBubbleSort extends Thread{

    private int[] iArray;

    public ThreadBubbleSort(int[] inputArray){
        iArray = inputArray;
    }

    @Override
        public void run(){
            sort();
            System.out.println(Thread.currentThread().getName());
        }

    public synchronized void sort(){

        MergeBubblesort bs = new MergeBubblesort();
        bs.sort(iArray);
    }
}
