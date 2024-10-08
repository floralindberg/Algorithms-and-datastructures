package LinkedList;

public class LinkedList2 {

    Node head; // This is the head of the list (the first element)

    public LinkedList2(int n) {

        Node last = null;

        for (int i = 0; i < n; i++) {

            last = new Node(i, last);

        }

        head = last;

    }

    private class Node {
        int content; // this is the content of the node
        Node address; // this is the address to the next node

        Node(int val, Node adr) {
            content = val;
            address = adr;
        }
    }

    public void add(int item) {
        // Skapa en ny cell med värdet/head first och lägg in Cellen längst fram i
        // listan

        Node newNode = new Node(item, head);

        head = newNode;

    }

    public int length() {

        int i = 0;

        Node current = head;

        if (current == null) {

            return i;
        }

        while (current.address != null) {

            i++;

            current = current.address;

        }
        return i + 1;

    }

    public boolean find(int item) {

        Node current = head;

        while (current.address != null) {

            if (current.content == item) {
                return true;
            }

            else {
                current = current.address;
            }
        }

        return false;
    }

    public void remove(int item) {

        Node current = head;
        Node previous = null;

        if (current == null) {
            return;
        }

        while (current.address != null) {

            if (current.content != item) {

                previous = current;
                current = current.address;
            }

            else if (previous == null) {

                head = current.address;
                return;
            }

            else if (current.content == item) {

                previous.address = current.address;
                return;
            }

        }

        previous.address = current.address;

    }

    public void printList() {

        Node current = head;

        while (current.address != null) {

            System.out.println(current.content);

            current = current.address;

        }
        System.out.println(current.content);

    }

    public void append(LinkedList2 b) {

        Node nxt = this.head;

        Node prv = null;

        while (nxt.address != null) {

            prv = nxt;

            nxt = nxt.address;

        }
        nxt.address = b.head;

        b.head = null;

    }

}
