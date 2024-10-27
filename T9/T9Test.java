package T9;

public class T9Test {

    private class Node {
        public Node[] next;
        public boolean valid;

        public Node() {
            next = new Node[27];
            valid = false;
        }
        
    
    // method that takes in characters and returns as int fro 0-26
    public static Integer code(char c) {

        if (c >= 'a' && c <= 'p') {
            return c - 'a';
        } else if (c > 'q' && c <= 'v') {
            return c - 'a' - 1;
        } else if (c > 'v' && c <= 'z') {
            return c - 'a' - 2;
        } else if (c == 'å') {
            return 24;
        } else if (c == 'ä') {
            return 25;
        } else if (c == 'ö') {
            return 26;
        }

        return null;

    }

    public static Character reversedCode(int i) {

        if (i < 0 || i > 26) {
            return null;
        }

        int j = 0;
        if (i >= 16) {
            j++;
        }
        if (i >= 22) {
            j++;
        }
        if (i == 24) {
            return 'å';
        }
        if (i == 25) {
            return 'ä';
        }

        if (i == 26) {
            return 'ö';
        }

        return ((char) ('a' + i + j));

    }

    public static void main(String[] args) {

        System.out.println(code('t'));

        System.out.println(reversedCode(18));

    }

    public int charToKey(char ch) {
        if (ch == 'a' || ch == 'b' || ch == 'c') {
            return 1;
        }
        if (ch == 'd' || ch == 'e' || ch == 'f') {
            return 2;
        }
        if (ch == 'g' || ch == 'h' || ch == 'i') {
            return 3;
        }
        if (ch == 'j' || ch == 'k' || ch == 'l') {
            return 4;
        }
        if (ch == 'm' || ch == 'n' || ch == 'o') {
            return 5;
        }
        if (ch == 'p' || ch == 'r' || ch == 's') {
            return 6;
        }
        if (ch == 't' || ch == 'u' || ch == 'v') {
            return 7;
        }
        if (ch == 'x' || ch == 'y' || ch == 'z') {
            return 8;
        } else if (ch == 'å' || ch == 'ä' || ch == 'ö') {
            return 9;
        }
        return -1;
    }
}
