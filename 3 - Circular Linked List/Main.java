
public class Main {

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.insertLast(0);
        circularLinkedList.insertLast(1);
        circularLinkedList.insertLast(2);
        circularLinkedList.insertLast(3);
        circularLinkedList.insertLast(4);
        circularLinkedList.insertLast(5);
        circularLinkedList.insertLast(6);
        circularLinkedList.insertLast(7);
        circularLinkedList.insertLast(8);
        circularLinkedList.insertLast(9);

        circularLinkedList.insertAfter(3, 33);
        circularLinkedList.insertAfter(7, 77);
        circularLinkedList.insertAfter(9, 99);
        circularLinkedList.insertAfter(0, -1);
        
        circularLinkedList.insertFirst(-100);
        circularLinkedList.insertFirst(-200);
        circularLinkedList.insertFirst(-300);

        circularLinkedList.delete(8);
        circularLinkedList.delete(7);
        circularLinkedList.delete(3);
        circularLinkedList.delete(99);
        circularLinkedList.delete(-300);

        //circularLinkedList.transversal(false);
        System.out.println(circularLinkedList.getSize());
    }
}