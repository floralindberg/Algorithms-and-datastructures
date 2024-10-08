package Searching;

public class BinarySearch {

    public static int a = 0;

    public static boolean binary_search(int[] array, int key) {

        int first = 0;
        int last = array.length - 1;

        while (true) {
            // jump to the middle
            int index = (last + first) / 2;

            if (array[index] == key) {
                return true;
            }

            if (first + 1 == last) {
                break;
            }

            if (array[index] < key && index < last) {
                // what is the first possible page?
                first = index;
                continue;
            }

            if (array[index] > key && index > first) {
                // what is the last possible page?
                last = index;
                continue;
            }

            // Why do we land here? What should we do?

        }
        return false;

    }

    public static boolean recursive(int[] arr, int key, int min, int max) {

        int mid = min + ((max - min) / 2);
        if (arr[mid] == key) {
            return true;
        }

        if (min + 1 == max) {
            return false;
        }

        if ((arr[mid] > key) && (min < mid)) {
            a++;
            recursive(arr, key, min, mid);

        }

        if ((arr[mid] < key) && (mid < max)) {
            a++;
            recursive(arr, key, mid, max);

        }

        return false;

    }

}
