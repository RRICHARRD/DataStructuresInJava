
/**
 * Class to represent a node 
 * 
 * @author Richard Guilherme
 * @version 1.0.0
 */
class Node {

    /**
     * Information to store inside the Node
     */
    private int data;

    /**
     * Address of another Node to create a chain between them
     */
    private Node next;

    /**
     * Class constructor
     */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    /**
     * @return Stored data inside the Node
     */
    public int getData() {
        return data;
    }

    /**
     * @return Address of next Node element
     */
    public Node getNext() {
        return next;
    }

    /**
     * Change the next Node address of current node
     * @param next Address of another Node
     */
    public void setNext(Node next) {
        this.next = next;
    }

}