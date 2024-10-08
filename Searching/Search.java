package Searching;

import java.util.Random;

public class Search {

    public static boolean unsorted_search(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }

    public static boolean sorted_search(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
            if (array[index + 1] > key) {
                return false;
            }
        }
        return false;
    }

}
