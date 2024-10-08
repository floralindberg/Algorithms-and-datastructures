package Sorting;


import java.util.Random;

public class SelectionSort {

    public static int candidate;
    static Random random = new Random();

    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            candidate = i;

            for (int j = i; j < array.length; j++) {

                if (array[candidate] > array[j]) {

                    candidate = j;
                }
            }
            swapElements(array, candidate, i);
        }

    }

    private static void swapElements(int[] array, int cand, int i) {
        int temp = array[i];
        array[i] = array[cand];
        array[cand] = temp;
    }

}
