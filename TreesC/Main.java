package TreesC;

import Trees.BinaryTree;

public class Main {

    public static void main(String[] args) {

        Breadth tree = new Breadth();

        tree.add(1, Breadth.root);
        tree.add(2, Breadth.root);
        tree.add(3, Breadth.root);
        tree.add(4, Breadth.root);
        tree.add(5, Breadth.root);
        tree.add(6, Breadth.root);

        tree.add(7, Breadth.root);
        tree.add(8, Breadth.root);
        /*
         * tree.add(7, Breadth.root);
         * tree.add(8, Breadth.root);
         * tree.add(9, Breadth.root);
         * tree.add(10, Breadth.root);
         * tree.add(11, Breadth.root);
         * tree.add(12, Breadth.root);
         * tree.add(13, Breadth.root);
         * tree.add(14, Breadth.root);
         * tree.add(15, Breadth.root);
         */

        Sequence sequence = new Sequence(Breadth.root);
        for (int i = 0; i < 3; i++) {
            System.out.println(sequence.next());
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(sequence.next());
        }

        tree.add(7, Breadth.root);
        tree.add(8, Breadth.root);

        System.out.println(sequence.next());
        System.out.println(sequence.next());
        System.out.println(sequence.next());
        System.out.println(sequence.next());
        // tree.print();

    }

}
