package QueueInArray;

public class QueueInArray {

    Integer head = null;

    Integer tail = null;

    int size = 4;

    Integer[] array;

    public QueueInArray(int size) {
        Integer[] array = new Integer[size];

        this.array = array;

    }

    public void increasedQueue() {

        Integer[] increasedQueue = new Integer[size * 2];

        int j = 0;

        for (int i = head; i < array.length; i++) {

            increasedQueue[j] = array[i];
            j++;

        }

        array = increasedQueue;
        head = 0;
        tail = j - 1;
        size = array.length;
    }

    public void decreasedQueue() {
        Integer[] decreasedQueue = new Integer[size / 2];

        int j = 0;

        if (tail == null) {
            for (int k = 0; k < (size / 2); k++) {
                decreasedQueue[k] = null;
            }

            array = decreasedQueue;
            head = null;
            tail = null;
            size = array.length;

        } else {
            for (int i = head; i < tail; i++) {

                decreasedQueue[j] = array[i];

                j++;
            }
            array = decreasedQueue;
            head = 0;
            tail = j;
            size = array.length;

        }

    }

    public Integer dequeue() {

        if (head == null) {
            System.out.println("No elements in queue");
            return null;

        }

        Integer item = array[head];

        array[head] = null;

        head++;

        if (head == size - 1) {
            head = null;
        }

        if (array[head] == null) {
            head = null;
            tail = null;

        }

        if (tail == null || tail < size / 3) {

            decreasedQueue();

        }

        return item;

    }

    public void enqueue(int item) {

        if (head == null) {
            head = 0;
            tail = 1;
            array[head] = item;

        }

        else if (tail == (size - 1)) {
            increasedQueue();
            array[tail] = item;
            tail++;
        }

        else {

            array[tail] = item;
            tail++;

        }

    }
}
