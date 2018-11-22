package baselab01.package02;

public class QuicksortSort {

    private long time = 0;
    private long startTime = 0;

    public void GetTime(){
        System.out.print("Time is " + time);
    }

    private void arrPrint(int[] arr){
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        //System.out.print("\n");
    }

    /* This function takes last element as pivot,
   places the pivot element at its correct
   position in sorted array, and places all
   smaller (smaller than pivot) to left of
   pivot and all greater elements to right
   of pivot */

    int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {

                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    int[] sort(int[] arr, int low, int high) {

        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
        return arr;
    }

    public void doQuickSort (int[] arr){

        if(arr.length > 0) {

            startTime = 0;
            startTime = System.nanoTime();

            int low = 0;
            int high = arr.length - 1;
            sort(arr, low, high);

            if (System.nanoTime() - startTime > 0)
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("doQuickSort [ ");
            arrPrint(arr);
            System.out.println("]");
        }else {
            System.out.print("Array is Empty");
            startTime = 0;
            return;
        }
    }

}

