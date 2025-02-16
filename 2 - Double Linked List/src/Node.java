
/**
 * Represent a node in the double linked list
 * 
 * @author Richard Guilherme
 * @version 1.0.0
 */
class Node {

    /**
     * Basic information to store inside the node
     */
    private int data;

    /**
     * Address of another node to chain
     */
    private Node next;

    /**
     * Address of another node to chain
     */
    private Node preview;

    /**
     * Node constructor
     * 
     * @param data information to store inside the node
     */
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.preview = null;
    }

    /**
     * @return Value stored inside the Node
     */
    public int getData() {
        return data;
    }

    /**
     * @return Address of next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Link that node to another node in the next field
     * 
     * @param next Address of next node in the heap memory
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * 
     * @return Address of preview node
     */
    public Node getPreview() {
        return preview;
    }

     /**
     * Link that node to another node in the preview field
     * 
     * @param preview Address of preview node in the heap memory
     */
    public void setPreview(Node preview) {
        this.preview = preview;
    }
}