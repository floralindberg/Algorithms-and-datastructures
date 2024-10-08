package QueueInArray;

public class Main {

    public static void main(String[] args) {
        
        QueueInArray newQueueInArray = new QueueInArray(4);

        newQueueInArray.enqueue(1);
        newQueueInArray.enqueue(2);
        newQueueInArray.enqueue(3);
        newQueueInArray.enqueue(4);
        newQueueInArray.enqueue(5);

        newQueueInArray.dequeue();
        newQueueInArray.dequeue();
        newQueueInArray.dequeue();
        newQueueInArray.dequeue();
        newQueueInArray.dequeue();

        newQueueInArray.enqueue(6);
        newQueueInArray.enqueue(7);
        newQueueInArray.enqueue(8);
        

    

        System.out.println(newQueueInArray.head);
        System.out.println(newQueueInArray.tail);



    }
    
}
