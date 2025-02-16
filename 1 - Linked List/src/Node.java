

/**
 * Basic class no represent an item in the the linked list
 */
public class Node { 
    
    /**
     * @param data Basic information to add in the Informação básica para inserir no nó do elemento
     */
    private int data;
    
    /**
     * @param next Another nome memory address to link nodes in the memory
     */
    private Node next;

    /**
     * Class constructor
     * 
     * @param data Information to store inside the node
     */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Add new link to another node
     * 
     * @param next A new node
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Get the next node memory
     * 
     * @return Node liked to the actual node
     */
    public Node getNext() {
        return this.next;
    }

    /**
     * Get the data stored in the node
     * 
     * @return The data stored inside the node
     */
    public int getData() {
        return this.data;
    }

}