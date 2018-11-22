package package01;

public class BubbleSort {

    private long time = 0;
    private long startTime = 0;

    public void GetTime(){
        System.out.print("Time is " + time);
    }

    public void sortBubbleFromFront(int[] ar ){

        if (ar.length != 0) {

            startTime = 0;
            startTime  = System.nanoTime();

            int[] arr = ar;

            System.out.print("Current array from BubbleSort.sortBubbleFromFront [ ");
            for (int i = 0; i < ar.length; i++)
                System.out.print(arr[i] + " ");

            System.out.println("]");

            for (int j = 0; j < arr.length - 1; j++) {
                for (int i = 0; i < arr.length - 1; i++) {

                    //todo uncomment for full steps changing in the array
                    //Полностю пошаговый вывод массива на каждом шагу
/*
                    System.out.print("\n");
                    System.out.print("j = " + j + " " + "i = " + i + " " +  "\t" + "arr = ");
                    for (int n = 0; n < ar.length; n++)
                        System.out.print(arr[n] + " ");
*/
                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i + 1];
                        arr[i + 1] = arr[i];
                        arr[i] = temp;

                        //todo uncomment for out steps ONLY WHEN THEY changing in the array
                        //Вывод только если меняется елементы в массиве
                 /*
                    System.out.print("\n" + "j = " + j + " " + "i = " + i + " " +  "\t" + "arr = ");
                    for (int n = 0; n < ar.length; n++)
                        System.out.print(arr[n] + " ");
                    */
                    }
                }
            }

            if ( System.nanoTime() - startTime > 0 )
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("sortBubbleFromFront [ ");
            for (int i = 0; i < ar.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println("]");
        }else {
            System.out.println("Array is Empty");
            startTime = 0;
            return;
        }
    }

    public void sortBubbleFromEnd(int[] ar ){

        // проверка на то что массив не пустой
        if (ar.length != 0) {

            startTime = 0;
            startTime  = System.nanoTime();

            int[] arr = ar;

            System.out.print("Current array from BubbleSort.sortBubbleFromEnd [ ");
            for (int i = 0; i < ar.length; i++)
                System.out.print(arr[i] + " ");

            System.out.println("]");

            for (int j = arr.length - 1; j > 0; j--) {
                for (int i = arr.length - 1; i > 0; i--){

                    //todo uncomment for full steps changing in the array
                    //Полностю пошаговый вывод массива на каждом шагу
  /*
                    System.out.print("\n");
                    System.out.print("j = " + j + " " + "i = " + i + " " +  "\t" + "arr = ");
                    for (int n = 0; n < ar.length; n++)
                        System.out.print(arr[n] + " ");

       */             if (arr[i] < arr[i - 1]) {
                        int temp = arr[i - 1];
                        arr[i - 1] = arr[i];
                        arr[i] = temp;

                        //todo uncomment for out steps ONLY WHEN THEY changing in the array
                        //Вывод только если меняется елементы в массиве
                 /*
                    System.out.print("\n" + "j = " + j + " " + "i = " + i + " " +  "\t" + "arr = ");
                    for (int n = 0; n < ar.length; n++)
                        System.out.print(arr[n] + " ");
                    */
                    }
                }
            }

            if ( System.nanoTime() - startTime > 0 )
                time = System.nanoTime() - startTime;
            else
                System.out.println("Time is less than zero. Variable overflow !");

            System.out.print("sortBubbleFromEnd [ ");
            for (int i = 0; i < ar.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println("]");
        }else {
            System.out.print("Array is Empty");
            startTime = 0;
            return;
        }
    }

}
