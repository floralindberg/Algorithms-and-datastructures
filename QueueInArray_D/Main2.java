package QueueInArray_D;

public class Main2 {

    public static void main(String[] args) {

        QueueInArray2 newQueueInArray2 = new QueueInArray2(4);

        newQueueInArray2.enqueue2(1);

        newQueueInArray2.dequeue2();
        newQueueInArray2.dequeue2();

        newQueueInArray2.enqueue2(100);
        newQueueInArray2.enqueue2(200);
        newQueueInArray2.enqueue2(300);
        newQueueInArray2.enqueue2(400);
        newQueueInArray2.enqueue2(500);

        newQueueInArray2.dequeue2();
        newQueueInArray2.dequeue2();
        newQueueInArray2.dequeue2();
        newQueueInArray2.dequeue2();

        newQueueInArray2.enqueue2(6);
        newQueueInArray2.enqueue2(7);
        newQueueInArray2.enqueue2(8);
        newQueueInArray2.enqueue2(9);
        newQueueInArray2.enqueue2(10);

        System.out.println(newQueueInArray2.first);
        System.out.println(newQueueInArray2.afterLast);

    }

}
