package Trees;

import java.util.Stack;

public class BinaryTree {

        private class Node {

                private Integer value;
                private Node left, right;

                private Node(Integer value) {
                        this.value = value;
                        this.left = this.right = null;
                }

                /*
                 * public void print() {
                 * if (left != null)
                 * left.print();
                 * System.out.println(value);
                 * if (right != null)
                 * right.print();
                 * }
                 */

                public void print() {
                        Stack<Node> stk = new Stack<Node>();
                        Node cur = root;
                        
                        while (cur.left != null) {
                                stk.push(cur);
                                cur = cur.left;
                        }

                        if (cur.left == null) {
                                stk.push(cur);
                        }

                        // move to the leftmost node
                        while (cur != null) {
                                System.out.println(cur.value);

                                // print value of node
                                if (cur.right != null && cur.left == null) {
                                        stk.pop();
                                        cur = cur.right;
                                        stk.push(cur);
                                } 
                                else if (cur.right != null) {
                                        cur = cur.right;
                                        stk.push(cur);
                                }
                                // move to the leftmost node, push nodes as you go
                                
                                 else {
                                        stk.pop();
                                        if (stk.isEmpty()) {
                                                return;
                                        }
                                        cur = stk.pop();
                                        // pop a node from the stack
                                }

                        }
                        // done

                }
        }

        public Node root; // ändrade till public

        public BinaryTree() {

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

                else if (value < currentNode.value) {
                        if (currentNode.left == null) {
                                Node left = new Node(value);
                                currentNode.left = left;
                                return;
                        }

                        else {
                                add(value, currentNode.left);
                        }
                }

                else if (value > currentNode.value) {
                        if (currentNode.right == null) {
                                Node right = new Node(value);
                                currentNode.right = right;
                                return;
                        } else {
                                add(value, currentNode.right);
                        }
                }

        }

        public boolean lookUp(Integer key) { // return true or false depending on if the value is found

                Node current = root;

                while (current != null) {

                        if (current.value.equals(key)) {
                                return true;
                        }

                        if (key < current.value) {
                                current = current.left;

                        } else if (key > current.value) {

                                current = current.right;
                        }
                }

                return false;
        }

}
