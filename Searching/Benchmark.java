package Searching;

import java.util.Arrays;
import java.util.Random;

public class Benchmark {

    int[] array;
    static Random random = new Random();

    public static int[] randomArray(int size) {
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(size * 2);
        }
        return randomArray;
    }

    public static int[] randomKeys(int size, int loop) {

        int[] keysArray = new int[loop];
        for (int i = 0; i < loop; i++) {
            keysArray[i] = random.nextInt(size * 2);
        }
        return keysArray;
    }

    public static int[] randomKeysSorted(int size, int loop) {

        Random rnd = new Random();
        int[] keysSorted = new int[loop];
        int nxt = 0;
        for (int i = 0; i < loop; i++) {
            nxt += rnd.nextInt(10) + 1;
            keysSorted[i] = nxt;
        }

        return keysSorted;
    }

    private static int[] sorted(int size) {
        Random rnd = new Random();
        int[] array = new int[size];
        int nxt = 0;
        for (int i = 0; i < size; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] sizes = { 100, 200, 400, 800, 1600, 3200, 12800, 25600, 3000000 };

        int loop = 100;

        int nrOfTest = 10000;

        BinarySearch.a = 0;

        for (int size : sizes) {

            // int[] arrayWithRandom = randomArray(size);
            int[] arrayWithSorted = sorted(size);
            // int[] arrayWithKeys = randomKeys(size, loop);
            int[] arrayWithKeys = randomKeysSorted(size, loop);
            int min = 0;
            int max = arrayWithSorted.length - 1;

            long minTime = Long.MAX_VALUE;

            for (int j = 0; j < nrOfTest; j++) {
                long time1 = System.nanoTime();
                for (int i = 0; i < arrayWithKeys.length; i++) {
                    // Search.unsorted_search(arrayWithRandom, arrayWithKeys[i]);
                    // Search.sorted_search(arrayWithSorted, arrayWithKeys[i]);
                    // BinarySearch.binary_search(arrayWithSorted, arrayWithKeys[i]);
                    BinarySearch.recursive(arrayWithSorted, arrayWithKeys[i], min, max);
                }

                long time2 = System.nanoTime();
                long time = time2 - time1;

                if (time < minTime) {
                    minTime = time;
                }
            }

            System.out.println(size + " " + (minTime / loop) + " nanoseconds");
            System.out.println("Recursive calls: " + BinarySearch.a / (loop * nrOfTest));
        }

    }
}
