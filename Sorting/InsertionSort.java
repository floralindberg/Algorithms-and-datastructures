package Sorting;

import java.util.Arrays;

public class InsertionSort {

public static void insertionSort (int [] array) 
{
    for (int i = 0; i < array.length; i++) {

        for (int j = i; j > 0 && array[j] < array[j-1] ; j--) {

        swapElements(array, j ,j-1);

        }
        }
    }

    private static void swapElements(int[] array, int cand, int i) {
        int temp = array[i];
        array[i] = array[cand];
        array[cand] = temp;
    }

 

    public static void main(String[] args) {
        int [] mineArray = {4, 3, 6, 5, 2, 1, 8,7 };

        insertionSort(mineArray);

        System.out.println(Arrays.toString(mineArray));
    }
}
