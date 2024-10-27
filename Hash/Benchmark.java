package Hash;

public class Benchmark {

    public static void bench(int nrOfTest) {

        long t0 = System.nanoTime();
        for (int i = 0; i < nrOfTest; i++) {
            Zip zip = new Zip("Hash/postnummer.csv");
            String zipToFind2 = "984 99";
            zip.findAreaLinear(zipToFind2);
        }
        long t1 = System.nanoTime();

        System.out.println("Benchtime: " + (t1 - t0));

    }

    public static void main(String[] args) {

        // Zip zip = new Zip("Hash/postnummer.csv");
        Zip2 zip = new Zip2("Hash/postnummer.csv");

        int nrOfTest = 1000;
        bench(100);

        // String zipToFind = "111 15";
        // String zipToFind2 = "984 99";
        Integer zipToFind = 11115;
        Integer zipToFind2 = 98499;

        long minTimelin = Long.MAX_VALUE;

        for (int i = 0; i < nrOfTest; i++) {
            long t0 = System.nanoTime();
            // zip.findAreaLinear(zipToFind);
            zip.findNodeLinear(zipToFind);

            long t1 = System.nanoTime();

            long timelin = t1 - t0;

            if (timelin < minTimelin && timelin > 0) {
                minTimelin = timelin;
            }

        }

        long minTimelin2 = Long.MAX_VALUE;

        for (int i = 0; i < nrOfTest; i++) {
            long t0 = System.nanoTime();
            // zip.findAreaLinear(zipToFind2);
            zip.findNodeLinear(zipToFind2);

            long t1 = System.nanoTime();

            long timelin2 = t1 - t0;

            if (timelin2 < minTimelin2 && timelin2 != 0) {
                minTimelin2 = timelin2;
            }

        }

        long minTimeBin = Long.MAX_VALUE;

        for (int i = 0; i < nrOfTest; i++) {
            long time0 = System.nanoTime();
            // zip.findAreaBinary(zipToFind);
            zip.findNode(zipToFind);

            long time1 = System.nanoTime();

            long time = time1 - time0;

            if (time < minTimeBin && time != 0) {
                minTimeBin = time;
            }

        }

        long minTimeBin2 = Long.MAX_VALUE;

        for (int i = 0; i < nrOfTest; i++) {
            long time2 = System.nanoTime();
            // zip.findAreaBinary(zipToFind2);
            zip.findNode(zipToFind2);

            long time3 = System.nanoTime();

            long timetime = time3 - time2;

            if (timetime < minTimeBin2 && timetime != 0) {
                minTimeBin2 = timetime;
            }

        }

        System.out.println("Zip code: " + zipToFind + ", Linear time:  " + minTimelin);
        System.out.println("Zip code: " + zipToFind2 + ", Linear time:  " + minTimelin2);
        System.out.println("Zip code: " + zipToFind + ", Binary time: " + minTimeBin);
        System.out.println("Zipcode: " + zipToFind2 + ", Binary time: " + minTimeBin2);

    }
}
