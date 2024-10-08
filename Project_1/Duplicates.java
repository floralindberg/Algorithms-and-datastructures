import java.util.Random;

public class Duplicates {
    public static void main(String[] args) {
      
        System.out.println(duplicates(100, 10) + " ns");
        System.out.println(duplicates(200, 10) + " ns");
        System.out.println(duplicates(400, 10) + " ns");
        System.out.println(duplicates(800, 10) + " ns");
        System.out.println(duplicates(1600, 10) + " ns");
    }

    private static long duplicates(int n, int loop) {
        Random rnd = new Random();
        int[] array_a = new int[n];
        for (int i = 0; i < n; i++) {
            array_a[i] = rnd.nextInt(n * 2);
        }
        int[] array_b = new int[n];
        for (int i = 0; i < n; i++) {
            array_b[i] = rnd.nextInt(n * 2);
        }
        int sum = 0;
        long t0 = System.nanoTime();
        for (int k = 0; k < loop; k++) {
            for (int i = 0; i < n; i++) {
                int key = array_a[i];
                for (int j = 0; j < n; j++) {
                    if (key == array_b[j]) {
                        sum++;
                        break;
                    }
                }
            }
        }
        long t1 = System.nanoTime();
        return t1 - t0;
    }

}
