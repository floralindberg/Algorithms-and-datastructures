package Test;

class ClockTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            long n0 = System.nanoTime();
            long n1 = System.nanoTime();
            System.out.println(" resolution " + (n1 - n0) + " nanoseconds");
            }
        }

}
/*  The code generates different mesurements of the resolution of the clock. The resaults are different because the clock is not perfect
 and System.nanoTime() is made up to be a high resultion - clock but is actually depending on the system in the computer.
 It can also depond on that the JVM (Java Vitrual Machine) is performing different optimizations each time the code is run.
 */