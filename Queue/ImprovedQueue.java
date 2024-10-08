package Queue;

public class ImprovedQueue {

    Node head;
    Node tail;

    private class Node {

        Integer content;
        Node address;

        private Node(Integer item, Node list) {

            this.content = item;
            this.address = list;
        }
    }

    public ImprovedQueue() {
        head = null;
        tail = null;

    }

    public void improvedEnqueue(Integer item) {

        Node newNode = new Node(item, null);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }

        else {

            tail.address = newNode;
            tail = newNode;
        }

        // Går igenom hela för att se var den sista noden är så att denna kan peka på
        // den nya sista

    }

    public Integer improvedDequeue() {

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
