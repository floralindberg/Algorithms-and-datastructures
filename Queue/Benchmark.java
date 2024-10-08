package Queue;

public class Benchmark {

    private static void bench(int nrOfTest) {
        {

            long t0 = System.nanoTime();

            Queue firstQueue = new Queue();

            for (int i = 0; i < nrOfTest; i++) {

                firstQueue.enqueue(i);

            }
            for (int i = 0; i < nrOfTest; i++) {

                firstQueue.dequeue();
                // System.out.println(firstQueue.dequeue());
            }

            long t1 = System.nanoTime();

            long benchTime = t1 - t0;

            System.out.println("BenchTime = " + benchTime);
            System.out.println();
        }
    }

    private static void enqueueTime(int loop, Queue firstQueue) {

        for (int i = 0; i < loop; i++) {

            firstQueue.enqueue(i);

        }

    }

    private static void enqueueTime2(int loop, ImprovedQueue firstQueue) {

        for (int i = 0; i < loop; i++) {

            firstQueue.improvedEnqueue(i);
        }

    }

    private static void dequeueTime(int loop, Queue firstQueue) {

        for (int i = 0; i < loop; i++) {

            firstQueue.dequeue();

        }

    }

    private static void dequeueTime2(int loop, ImprovedQueue firstQueue) {

        for (int i = 0; i < loop; i++) {

            firstQueue.improvedDequeue();

        }

    }

    public static void main(String[] args) {

        bench(10000);

        int[] sizes = { 100, 200, 400, 800, 1600, 3200 };

        int nrOfTest = 100000;

        for (int size : sizes) {

            long minTimeEnq = Long.MAX_VALUE;
            long minTimeDeq = Long.MAX_VALUE;

            for (int i = 0; i < nrOfTest; i++) {

                // Queue firstQueue = new Queue();
                ImprovedQueue firstQueue = new ImprovedQueue();

                long t0 = System.nanoTime(); // För v2
                // enqueueTime(size, firstQueue); // För v1
                enqueueTime2(size, firstQueue); // För v2

                // long t0 = System.nanoTime(); //För v1
                // firstQueue.enqueue(1); // För v1
                firstQueue.improvedEnqueue(1); // För v2

                long t1 = System.nanoTime();

                long timeEnq = t1 - t0;

                if (timeEnq < minTimeEnq) {
                    minTimeEnq = timeEnq;
                }

                long time0 = System.nanoTime();

                // dequeueTime(size-1, firstQueue);
                dequeueTime2(size - 1, firstQueue);

                long time1 = System.nanoTime();

                long timeDeq = time1 - time0;

                if (timeDeq < minTimeDeq) {
                    minTimeDeq = timeDeq;
                }

            }
            System.out.println(size + " Enqueue time: " + (minTimeEnq / size));
            System.out.println(size + " Dequeue time: " + (minTimeDeq / size));
            System.out.println();

        }
    }
}
