package Sorting;

import java.util.Arrays;

public class Merge {

    public static void sortStart(int[] org) {
        if (org.length == 0)
            return;

        int[] aux = new int[org.length];

        sort(org, aux, 0, org.length - 1);
      

    }

    private static void sort(int[] org, int[] aux, int lowerIndex, int lastIndex) {

        if (lowerIndex != lastIndex) {

            int mid = (lowerIndex + lastIndex) / 2;

            // sort the items from lowerIndex to mid
            sort(org, aux, lowerIndex, mid);

            // sort the items from mid+1 to lastIndex
            sort(org, aux, mid + 1, lastIndex);

            // merge the two sections using the additional array

            merge(org, aux, lowerIndex, mid, lastIndex);
        }
    }

    private static void merge(int[] org, int[] aux, int lowerIndex, int mid, int lastIndex) {
        // copy all items from lowerIndex to lastIndex from org to aux
        for (int i = 0; i <= lastIndex; i++) {
            aux[i] = org[i];
        }
        // let's do the merging
        int i = lowerIndex; // the index in the first part
        int j = mid + 1; // the index in the second part

        // for all indices from lowerIndex to lastIndex
        for (int k = lowerIndex; k <= lastIndex; k++) {

            // if i is greater than mid then
            // move the j'th item to the org array, update j
            if (i > mid) {
                org[k] = aux[j++];

            }

            // else if j is greate than lastIndex then
            // move the i'th item to the org array, update i
            else if (j > lastIndex) {
                org[k] = aux[i++];

            }
            // else if the i'th item is smaller than the j'th item,
            // move the i'th item to the org array, update i
            else if (aux[i] < aux[j]) {
                org[k] = aux[i++];

            }
            // else
            // move the j'th item to the org array, update j
            else {
                org[k] = aux[j++];

            }
        }
    }

    public static void main(String[] args) {
        int [] array = {2, 5, 6, 9, 1, 4, 3, 7, 8};
        sortStart(array);
        
    }
}
