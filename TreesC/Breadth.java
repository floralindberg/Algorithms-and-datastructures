package TreesC;

public class Breadth {

    public static Node root;

    public static class Node {

        private Integer value;
        private Node left, right;

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
        }

        else if (value == currentNode.value) {
            return;
        }

        else if (currentNode.left == null) {
            currentNode.left = new Node(value);
            return;
        }

        else if (currentNode.right == null) {
            currentNode.right = new Node(value);
            return;

        }

        else {
            if (currentNode.left != null && (currentNode.left.left == null || currentNode.left.right == null)) {
                add(value, currentNode.left);
            } else {
                add(value, currentNode.right);
            }
        }
    }

}
