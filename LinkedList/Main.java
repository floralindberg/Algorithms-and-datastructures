package LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList2 linkedList = new LinkedList2 ();
        LinkedList2 anotherLinkedlist = new LinkedList2();

        anotherLinkedlist.add(100);
        anotherLinkedlist.add(200);
        anotherLinkedlist.add(300);
        anotherLinkedlist.add(400);
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.remove(1);
        linkedList.remove(3);
        linkedList.remove(5);

        linkedList.append(anotherLinkedlist);
        

        System.out.println("Is the item found in the list? : " + linkedList.find(5));

        linkedList.printList();

       System.out.println("Length of the list: " + linkedList.length());



        
    }
}
