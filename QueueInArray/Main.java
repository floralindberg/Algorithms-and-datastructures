package QueueInArray;

public class Main {

    public static void main(String[] args) {

        QueueInArray newQueueInArray = new QueueInArray(4);

        newQueueInArray.enqueue(1);
        newQueueInArray.enqueue(2);

        newQueueInArray.dequeue();
        newQueueInArray.dequeue();
        newQueueInArray.dequeue();
        newQueueInArray.dequeue();
        newQueueInArray.dequeue();

        newQueueInArray.enqueue(6);
        newQueueInArray.enqueue(7);
        newQueueInArray.enqueue(8);
        newQueueInArray.enqueue(9);
        newQueueInArray.enqueue(10);

        System.out.println(newQueueInArray.first);
        System.out.println(newQueueInArray.afterLast);

    }

}
