package LinkedList;

import java.util.Arrays;

public class AppendArray {

    public static void appendArray(int [] arrayA, int [] arrayB) {

        int [] appendedArray  = new int[arrayA.length + arrayB.length];
        int i = 0; 
    
        for (int j= 0; j < arrayA.length; j++) {
            
                appendedArray[j] = arrayA[j];
                i++;
    
        }

        for(int j =0; j < arrayB.length;j++) {

            appendedArray[i] = arrayB[j];
            i++;
            
        }
      
            System.out.println(Arrays.toString(appendedArray));
        }
    

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        int [] array2 = {10,11,12,13,14};

        appendArray(array1,array2);
    }
}
