package QueueInArray_D;

public class QueueInArray2 {

    Integer first = 0;

    Integer afterLast = 0;

    int size = 4;

    Integer[] array;

    public QueueInArray2(int size) {
        Integer[] array = new Integer[size];

        this.array = array;

    }

    public void increasedQueue2() {

        Integer[] increasedQueue = new Integer[size * 2];
        int j = 0;

        for (int i = 0; i < size; i++) {
            increasedQueue[j] = array[(first + i) % size];
            j++;
        }
        array = increasedQueue;
        first = 0;
        afterLast = size;
        size = array.length;

    }

    public void decreasedQueue2() {

        if ((size / 2) < 4) {
            return;
        }

        Integer[] decreasedQueue = new Integer[size / 2];
        int j = 0;

        for (int i = 0; i < size; i++) {
            decreasedQueue[j] = array[(first + i) % size];
            j++;
        }

        array = decreasedQueue;
        first = 0;
        afterLast = j;
        size = array.length;

    }

    public Integer dequeue2() {

        if (array[first] == null) {
            System.out.println("Queue is empty");
            decreasedQueue2();
            return null;
        }

        Integer item = array[first];
        array[first] = null;
        first = (first + 1) % size;

        if (array[first] == null) {
            first = 0;
            afterLast = 0;
        }

        if (Math.abs(first - afterLast) <= size / 4) {

            decreasedQueue2();
        }

        return item;

    }

    public void enqueue2(int item) {

        array[afterLast] = item;
        afterLast = (afterLast + 1) % size;

        if (first == afterLast) {
            increasedQueue2();

        }

    }

public void test

}