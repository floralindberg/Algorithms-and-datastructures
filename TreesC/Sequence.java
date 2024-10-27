package TreesC;

public class Sequence {

    private ImprovedQueue queue;

    Sequence(Breadth.Node root) {
        this.queue = new ImprovedQueue();
        if (root != null) {
            queue.improvedEnqueue(root);
        }
    }

    public Integer next() {

        Breadth.Node cur = queue.improvedDequeue();

        if (cur == null) {
            return null;
        }

        if (cur.left != null) {
            queue.improvedEnqueue(cur.left);
        }

        if (cur.right != null) {
            queue.improvedEnqueue(cur.right);
        }

        return cur.value;
    }
}
