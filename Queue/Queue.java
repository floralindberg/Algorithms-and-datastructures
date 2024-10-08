package Queue;

public class Queue {

    Node head;

    private class Node {

        Integer content;
        Node address;

        private Node(Integer item, Node list) {

            this.content = item;
            this.address = list;
        }
    }

    public Queue() {
        head = null;

    }

    public void enqueue(Integer item) {

        Node newNode = new Node(item, null);

        if (head == null) {
            head = newNode;
        }

        else {

            Node current = head;

            while (current.address != null) {
                current = current.address;
            }
            current.address = newNode;
        }

        // Går igenom hela för att se var den sista noden är så att denna kan peka på
        // den nya sista

    }

    public Integer dequeue() {

        if (head == null) {
            return null;

        } else {

            int content = head.content;
            head = head.address;
            return content;
        }

    }
    // Returnerar det första elementet dvs head och gör nästa node till head.

}
