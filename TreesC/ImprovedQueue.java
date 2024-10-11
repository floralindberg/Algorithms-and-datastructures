package TreesC;

public class ImprovedQueue {

    QueueNode head;
    QueueNode tail;

    private class QueueNode {

        Breadth.Node treeNode;
        QueueNode queueNode;

        private QueueNode(Breadth.Node treeNode, QueueNode queueNode) {

            this.treeNode = treeNode;
            this.queueNode = queueNode;
        }

    }

    public ImprovedQueue() {
        head = null;
        tail = null;

    }

    public void improvedEnqueue(Breadth.Node item) {

        QueueNode newNode = new QueueNode(item, null);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }

        else {

            tail.queueNode = newNode;
            tail = newNode;
        }

        // Går igenom hela för att se var den sista noden är så att denna kan peka på
        // den nya sista

    }

    public Breadth.Node improvedDequeue() {

        if (head == null) {
            return null;

        } else {

            Breadth.Node deqNode = head.treeNode;
            head = head.queueNode;
            return deqNode;
        }

    }
    // Returnerar det första elementet dvs head och gör nästa node till head.

    
}
