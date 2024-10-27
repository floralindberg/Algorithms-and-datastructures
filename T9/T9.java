package T9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class T9 {

    static Node root;
    public List<String> wordsList;

    private class Node {
        public Node[] next;
        public boolean valid;

        public Node() {
            next = new Node[27];
            valid = false;
        }
    }

    public T9(String filePath) {
        root = new Node();
        wordsList = new ArrayList<>();
        addFromFile(filePath);

    }

    public void add(String word) {

        Node current = root;

        for (char c : word.toCharArray()) {
            int index = charToCode(c);
            if (current.next[index] == null) {
                current.next[index] = new Node();
            }
            current = current.next[index];

        }
        current.valid = true; // when whole word add - set true, indicate word done.

    }

    public void addFromFile(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String word;
            StringBuilder codeString = new StringBuilder();

            while ((word = br.readLine()) != null) {
                add(word);
                codeString.setLength(0);

                for (char c : word.toCharArray()) {
                    charToKey(c);
                    codeString.append(charToKey(c));
                }
                wordsList.add(codeString.toString());
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public ArrayList<String> decode(String sequence) {
        ArrayList<String> possibleWords = new ArrayList<>();
        collect(0, sequence, root, possibleWords, ""); // method for collecting the possible words and piutting them in
                                                       // arrayList
        return possibleWords;

    }

    public static void collect(int position, String sequence, Node node, ArrayList<String> possibleWords,
            String possibleWord) {

        if (node == null) {
            return;
        }
        if (position == sequence.length()) { // kolla om sekensen gått igenom
            if (node.valid) {
                possibleWords.add(possibleWord);
            }
            for (int i = 0; i < node.next.length; i++) {
                if (node.next[i] != null) {
                    char c = codeToChar(i);
                    collect(position, sequence, node.next[i], possibleWords, possibleWord + c);
                }
            }
            return;
        }

        char key = sequence.charAt(position);
        int index = keyToIndex(key);
        if (index != -1) {
            for (int i = 0; i < 3; i++) {
                char c = codeToChar(index * 3 + i);
                collect(position + 1, sequence, node.next[index * 3 + i], possibleWords, possibleWord + c);
            }
        }
    }

    public static int charToCode(char w) {
        switch (w) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            case 'i':
                return 8;
            case 'j':
                return 9;
            case 'k':
                return 10;
            case 'l':
                return 11;
            case 'm':
                return 12;
            case 'n':
                return 13;
            case 'o':
                return 14;
            case 'p':
                return 15;
            case 'r':
                return 16;
            case 's':
                return 17;
            case 't':
                return 18;
            case 'u':
                return 19;
            case 'v':
                return 20;
            case 'x':
                return 21;
            case 'y':
                return 22;
            case 'z':
                return 23;
            case 'å':
                return 24;
            case 'ä':
                return 25;
            case 'ö':
                return 26;
            default:
                return -1;
        }
    }

    private static char codeToChar(int code) {
        switch (code) {
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
            case 8:
                return 'i';
            case 9:
                return 'j';
            case 10:
                return 'k';
            case 11:
                return 'l';
            case 12:
                return 'm';
            case 13:
                return 'n';
            case 14:
                return 'o';
            case 15:
                return 'p';
            case 16:
                return 'r';
            case 17:
                return 's';
            case 18:
                return 't';
            case 19:
                return 'u';
            case 20:
                return 'v';
            case 21:
                return 'x';
            case 22:
                return 'y';
            case 23:
                return 'z';
            case 24:
                return 'å';
            case 25:
                return 'ä';
            case 26:
                return 'ö';
            default:
                return '?';
        }
    }

    public static int keyToIndex(char key) {
        int i = Character.getNumericValue(key);
        if (i < 0 || i > 9) {
            return -1;
        } else {
            return i - 1;
        }
    }

    public static char charToKey(char letter) {
        switch (letter) {
            case 'a':
            case 'b':
            case 'c':
                return '1';
            case 'd':
            case 'e':
            case 'f':
                return '2';
            case 'g':
            case 'h':
            case 'i':
                return '3';
            case 'j':
            case 'k':
            case 'l':
                return '4';
            case 'm':
            case 'n':
            case 'o':
                return '5';
            case 'p':
            case 'q':
            case 'r':
            case 's':
                return '6';
            case 't':
            case 'u':
            case 'v':
                return '7';
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                return '8';
            default:
                return '?';
        }
    }

}
