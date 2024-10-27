package TreesC;

public class Breadth {

    public static Node root;

    public static class Node {

        public Integer value;
        public Node left, right;

        public Node(Integer value) {
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {
            ImprovedQueue queue = new ImprovedQueue();

            Node cur = root;

            if (cur == null) {
                return;
            }

            queue.improvedEnqueue(cur);
            queue.improvedDequeue();

            while (cur != null) {
                System.out.println(cur.value);

                queue.improvedEnqueue(cur.left);
                queue.improvedEnqueue(cur.right);

                cur = queue.improvedDequeue();

            }
        }

    }

    public Breadth() {

        root = null;
    }

    public void print() {
        root.print();

    }

    void add(Integer value, Node currentNode) { // takes the value of the node that should be added and the node to
        // compare to, at first root

        if (currentNode == null) {
            root = new Node(value);
            return;
        }

        if (value == currentNode.value) {
            return;
        }

        ImprovedQueue queue = new ImprovedQueue();
        queue.improvedEnqueue(currentNode);

        while (true) {
            currentNode = queue.improvedDequeue();

            if (currentNode.left == null) {
                currentNode.left = new Node(value);
                return;
            } else {
                // Om vänstra noden inte är tom, lägg till den i kön
                queue.improvedEnqueue(currentNode.left);
            }

            if (currentNode.right == null) {
                currentNode.right = new Node(value);
                return;
            } else {
                queue.improvedEnqueue(currentNode.right);
            }
        }
    }

}