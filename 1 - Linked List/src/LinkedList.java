
/**
 * Class to represent a linked list
 * 
 * @author Richard Guilherme
 * @version 1.0.0
 */
public class LinkedList {
    
    private int size;
    private Node head;
    private Node last;
    private boolean allowShowExceptionInterminal;

    /**
     * Class constructor
     */
    public LinkedList() {
        this.size = 0;
        this.head = null;
        this.last = null;
        this.allowShowExceptionInterminal = false;
    }

    /**
     * Increase size of the linked list in one unity
     */
    private void increaseSize() {
        this.size++;
    }

    /**
     * Decrease size of the linked in one unity
     */
    private void decreaseSize() {
        this.size--;
    }

    /**
     * Get size of linked list
     * 
     * @return Current size of linked list in decimal number
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Active the functionality to show exceptions in the terminal
     * 
     * @param value On of Off the functionality
     */
    public void setAllowShowExceptionInterminal(boolean value) {
        this.allowShowExceptionInterminal = value;
    }

    /**
     * Create a new node in the linked list
     * 
     * @return Return a simple node
     */
    private Node createNode(int data) {
        return new Node(data);
    }

    /**
     * Insert new node at the beginning of the linkedlist
     * 
     * @hidden Time complexity here is O(1) because we always have the address of the first node
     * 
     * @param data An information to store inside first node
     */
    public void insertBegin(int data) {
        Node newNode = createNode(data);
        newNode.setNext(this.head);
        
        this.head = newNode;
        this.increaseSize();
    }

    /**
     * Add a new node at the final of liked list
     * 
     * @hidden Time complexity is O(1), because we always have the address of last node
     * 
     * @param data Information to represente an element
     */
    public void insertLast(int data) {
        Node newNode = createNode(data);

        if (this.head == null) {
            this.head = newNode;
            this.last = newNode;
            this.increaseSize();
            return;
        }

        if (this.head == this.last) {
            this.head.setNext(newNode);
            this.last = newNode;
            this.increaseSize();
            return;
        }

        this.last.setNext(newNode);
        this.last = newNode;
        this.increaseSize();
    }

    /**
     * Find first node with the specied data, this function is a DRY to find nodes
     * 
     * @hidden Time complexity here is O(n), because we need to check intire linkedlist
     * 
     * @param data Information stored inside the node
     * @return Node memory address if any node inside linkded list contain the specified value
     * @throws Exception If not found any node with specied value
     */
    private Node getNode(int data) throws Exception {
        if (this.head.getData() == data) return this.head;

        Node tempNode = this.head;

        while (this.head != null) {
            if (tempNode.getData() == data) return tempNode;
            tempNode = tempNode.getNext();
        }

        throw new Exception("Not found node with the value %d".formatted(data));
    }

    /**
     * Find preview first node with the specied data, this function is a DRY to find nodes. This method 
     * obviously must not be used to get before node of Head node, because Head node is the first node
     * 
     * @hidden Time complexity here is O(n), because we need to check intire linkedlist
     * 
     * @param data Information stored inside the node
     * @return Previews node memory address of first any node inside linkded list that contains the specified value
     * @throws Exception If not found any node with specied value
     */
    private Node getPreviewNode(int data) throws Exception {
        Node tempNode = this.head;

        while (this.head != null) {
            if (tempNode.getNext().getData() == data) return tempNode;
            tempNode = tempNode.getNext();
        }

        throw new Exception("Not found node with the value %d".formatted(data));
    }

    /**
     * DRY for show exceptions in the terminal or log file in the future if necessary
     * 
     * @param e Exception instance
     */
    private void showExceptions(Exception e) {
        if (this.allowShowExceptionInterminal) {
            e.printStackTrace();
            System.err.println("error " + e.getMessage());
        }
    }

    /**
     * Insert new node after the first node with specified data value
     * 
     * @hidden Time complexity here is O(n), because i need to check one by one from the beggining to final to find always 
     * 
     * @param data
     */
    public void insertAfter(int existedData, int data) {
        try {
            Node foundNode = this.getNode(existedData);
            Node newNode = createNode(data);
            newNode.setNext(foundNode.getNext());
            foundNode.setNext(newNode);
            this.increaseSize();
        } catch (Exception e) {
            this.showExceptions(e);
        }
    }

    /**
     * Show all nodes presents in the linked list
     */
    public void transversal() {
        Node temp = head;

        while(temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    /**
     * Delete a node with especified value 
     * 
     * This method will dele the first finded node with de specified data value
     * 
     * @param data The value presente inside de node
     */
    public void delete(int data) {
        if (this.head.getData() == data) {
            Node headNode = this.head;
            this.head = this.head.getNext();
            
            headNode.setNext(null);
            headNode = null;
            this.decreaseSize();
            return;
        }

        try {
            Node foundPreviewNode = this.getPreviewNode(data);

            if (foundPreviewNode.getNext() == this.last) {
                this.last = foundPreviewNode;
                foundPreviewNode.setNext(null);
                this.decreaseSize();
                return;
            }

            foundPreviewNode.setNext(foundPreviewNode.getNext().getNext());
            this.decreaseSize();
        } catch (Exception e) {
            showExceptions(e);
        }
    }
}
