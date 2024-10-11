package QueueInArray_D;

public class QueueInArray {

    Integer first = null;

    Integer afterLast = null;

    int size = 4;

    Integer[] array;

    public QueueInArray(int size) {
        Integer[] array = new Integer[size];

        this.array = array;

    }

    public void increasedQueue() {

        Integer[] increasedQueue = new Integer[size * 2];

        int j = 0;

        for (int i = first; i < array.length; i++) {

            increasedQueue[j] = array[i];
            j++;

        }

        array = increasedQueue;
        first = 0;
        afterLast = j - 1;
        size = array.length;
    }

    public void decreasedQueue() {
        Integer[] decreasedQueue = new Integer[size / 2];

        int j = 0;

        if ((size / 2) < 4) {
            return;
        }

        else {
            if (afterLast == null) {
                for (int k = 0; k < (size / 2); k++) {
                    decreasedQueue[k] = null;
                }

                array = decreasedQueue;
                first = null;
                afterLast = null;
                size = array.length;

            } else {
                for (int i = first; i < afterLast; i++) {

                    decreasedQueue[j] = array[i];

                    j++;
                }
                array = decreasedQueue;
                first = 0;
                afterLast = j;
                size = array.length;

            }
        }

    }

    public Integer dequeue() {

        if (first == null) {
            System.out.println("Queue is empty");
            decreasedQueue();
            return null;

        }

        Integer item = array[first];

        array[first] = null;

        first++;

        if (first == size - 1) {
            first = null;
        }

        if (array[first] == null) {
            first = null;
            afterLast = null;

        }

        if (afterLast == null || afterLast < size / 3) {

            decreasedQueue();

        }

        return item;

    }

    public void enqueue(int item) {

        if (first == null) {
            first = 0;
            afterLast = 1;
            array[first] = item;

        }

        else if (afterLast == (size - 1)) {
            increasedQueue();
            array[afterLast] = item;
            afterLast++;
        }

        else {

            array[afterLast] = item;
            afterLast++;

        }

    }
}
