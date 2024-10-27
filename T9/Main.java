package T9;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        T9 t9 = new T9("T9/kelly.txt");

        ArrayList<String> possibleWords = t9.decode("455636");

        for (String word : possibleWords) {
            System.out.println(word);
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {

            System.out.println(t9.decode(t9.wordsList.get(i)));
            System.out.println();

        }

    }

}
