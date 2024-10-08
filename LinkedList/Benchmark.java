package LinkedList;

import java.util.Random;

public class Benchmark {

    static Random random = new Random();

    private static void bench(int size, int nrOfTest) {
        {

            long t0 = System.nanoTime();

            LinkedList2 firstList = new LinkedList2(size);
            LinkedList2 secondList = new LinkedList2(nrOfTest);

            for (int i = 0; i < nrOfTest; i++) {

                firstList.append(secondList);

            }

            long t1 = System.nanoTime();

            long benchTime = t1 - t0;

            System.out.println("BenchTime = " + benchTime);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] sizes = { 1000, 2000, 4000, 8000, 16000, 32000 };
        int sizeForFixed = 100000;

        bench(1000, 10000);

        int nrOfTests = 1000;

        for (int size : sizes) {

            LinkedList2 firstList = new LinkedList2(size);
            LinkedList2 secondList = new LinkedList2(sizeForFixed);

            long minTime = Long.MAX_VALUE;

            for (int i = 0; i <= nrOfTests; i++) {

                long time1 = System.nanoTime();
                firstList.append(secondList);
                long time2 = System.nanoTime();

                long time = time2 - time1;

                if (time < minTime) {
                    minTime = time;
                }

            }

            System.out.println("Size: " + firstList.length() + "; Time: " + (minTime) + " nanoseconds");

        }

    }
}
