package Queue;

public class Main {

    public static void main(String[] args) {
        ImprovedQueue testingQueue = new ImprovedQueue();

        testingQueue.improvedEnqueue(1);
        testingQueue.improvedEnqueue(2);
        testingQueue.improvedEnqueue(3);
        testingQueue.improvedEnqueue(4);

        System.out.println(testingQueue.improvedDequeue());

        


    }
    
}
