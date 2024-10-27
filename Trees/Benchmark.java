package Trees;

import java.util.Random;

public class Benchmark {

    static Random random = new Random();

    private static void bench(int size, int nrOfTest) {

        long time0 = System.nanoTime();

        {

            for (int j = 0; j < nrOfTest; j++) {
                BinaryTree tree = new BinaryTree();

                for (int i = 0; i < nrOfTest; i++) {

                    tree.add(random.nextInt(size * 2), tree.root);
                    i++;

                }
            }

            long time1 = System.nanoTime();

            long benchTime = time1 - time0;

            System.out.println("BenchTime = " + benchTime);
            System.out.println();
        }

    }

    public static Integer[] randomKeys(Integer size) {

        Integer[] keysArray = new Integer[size];
        for (int i = 0; i < size; i++) {
            keysArray[i] = random.nextInt(size * 2);
        }

        return keysArray;
    }

    public static void main(String[] args) {

        // BinaryTree tree = new BinaryTree();

        /*
         * tree.add(8,tree.root);
         * tree.add(4,tree.root);
         * tree.add(6,tree.root);
         * tree.add(3,tree.root);
         * tree.add(9,tree.root);
         * 
         * System.out.println(tree.lookUp(7));
         * System.out.println(tree.lookUp(4));
         */

        bench(1000, 10000);

        int[] sizes = { 10, 1000, 2000, 4000, 8000, 16000, 32000 };

        int nrOfTests = 1000;

        for (int size : sizes) {

            Integer[] arrayWithKeys = randomKeys(size);

            long minTime = Long.MAX_VALUE;
            long minTimeAdd = Long.MAX_VALUE;
            long timeAdd = 0;
            long timeLook = 0;

            for (int i = 0; i < nrOfTests; i++) {

                BinaryTree tree = new BinaryTree();
                tree.add((size * 10 / 2), tree.root);

                for (int j = 0; j < size; j++) {
                    tree.add(random.nextInt(size * 10), tree.root);
                }

                long time0 = System.nanoTime();
                for (int j = 0; j < 100; j++) {
                    tree.add(random.nextInt(size * 2), tree.root);
                }
                long time1 = System.nanoTime();

                timeAdd += time1 - time0;
                long timetime = time1 - time0;

                if (minTimeAdd > timetime) {
                    minTimeAdd = timetime;
                }

                // benchmark for lookUp
                long t0 = System.nanoTime();

                for (Integer key : arrayWithKeys) {

                    tree.lookUp(key, tree.root);
                }

                long t1 = System.nanoTime();

                long time = t1 - t0;
                timeLook += t1 - t0;

                if (time < minTime) {
                    minTime = time;
                }
            }

            System.out.println("Size: " + size);
            System.out.println("Avrg time - add: " + timeAdd / (nrOfTests * 100));
            System.out.println("Min time - add: " + minTimeAdd / 100);
            System.out.println("Avrg time - lookUp: " + timeLook / (nrOfTests * size));
            System.out.println("Min time - lookUp: " + minTime / size);
            System.out.println();

        }

    }

}
