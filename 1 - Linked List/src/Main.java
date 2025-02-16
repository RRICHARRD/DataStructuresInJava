public class Main {

    public static void main(String args[]) {

        LinkedList linkedList = new LinkedList();

        linkedList.insertLast(10);
        linkedList.insertLast(20);
        linkedList.insertLast(30);
        linkedList.insertLast(40);
        linkedList.insertLast(50);
        linkedList.insertLast(60);
        linkedList.insertLast(70);
        linkedList.insertLast(80);
        linkedList.insertLast(90);
        linkedList.insertLast(100);
        
        linkedList.delete(100);
    
        linkedList.insertLast(150);
        linkedList.insertLast(160);

        linkedList.insertBegin(-10);
        linkedList.insertBegin(-20);
        linkedList.insertBegin(-30);
        linkedList.insertBegin(-40);
        linkedList.insertBegin(-50);

        linkedList.delete(-30);
    
        //linkedList.transversal();
        //System.out.println("");

        linkedList.insertAfter(40, 400);
        //linkedList.transversal();

        System.out.println(linkedList.getSize());
    }
}