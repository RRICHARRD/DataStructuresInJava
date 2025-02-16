

public class Main {
    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.insertLast(1);
        doubleLinkedList.insertLast(2);
        doubleLinkedList.insertLast(3);
        doubleLinkedList.insertLast(4);
        doubleLinkedList.insertLast(5);
        doubleLinkedList.insertLast(6);
        doubleLinkedList.insertLast(7);
        doubleLinkedList.insertLast(8);
        doubleLinkedList.insertLast(9);

        doubleLinkedList.insertAfter(55, 550);

        doubleLinkedList.delete(99);
        doubleLinkedList.delete(9);

        //doubleLinkedList.transversal(true);

        System.out.println(doubleLinkedList.getSize());
    }
}
