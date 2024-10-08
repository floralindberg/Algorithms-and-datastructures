package Sorting;

import java.util.Random;
import java.util.Arrays;

public class BenchmarkForSorting {


    int[] array;
    static Random random = new Random();
    static long benchTime;

    public static int[] randomArray(int size) {

        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(size * 2);
        }
        return randomArray;
    }
  
    private static void bench(int size, int nrOfTest) {
     {
        int[] warmupArray = randomArray(size);

        long t0 = System.nanoTime();

        for (int i = 0; i < nrOfTest; i++) {

            //InsertionSort.insertionSort(warmupArray); // warmup with insertion sort
            //SelectionSort.selectionSort(warmupArray);
            Merge.sortStart(warmupArray);
        
        }

        long t1 = System.nanoTime();

        long benchTime = t1-t0;
        
        System.out.println("BenchTime = " + benchTime);
        System.out.println();
    }
}

    public static void main(String[] args) {
        int[] sizes = { 100, 200, 400, 800, 1600, 3200};
        

        int nrOfTest = 1000;

        bench(1000, 1000);

        for (int size : sizes) {
            int [] array = randomArray(size);
           

            long minTime = Long.MAX_VALUE;

            for (int j = 0; j < nrOfTest; j++) {


                long time1 = System.nanoTime();
                
               //SelectionSort.selectionSort(array);
                //InsertionSort.insertionSort(array);
                Merge.sortStart(array);

                long time2 = System.nanoTime();
                long time = time2 - time1;

                if (time < minTime) {
                    minTime = time;
                }
                
            }

            System.out.println(size + " " + minTime  + " nanoseconds");
        
        }

    }
}

