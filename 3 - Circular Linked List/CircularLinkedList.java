
/**
 * Class to represent a CircularLinkedList
 * 
 * @author Richard Guilherme
 * @version 1.0.0
 */
public class CircularLinkedList {

    /**
     * First Node of CircularLinkedList
     */
    private Node head;

    /**
     * Last Node of CircularLinkedList
     */
    private Node last;

    /**
     * Variable to indicate if is necessary to show exception in the terminal, that
     * is commomlly used in {@link #insertAfter()} {@link #delete()} 
     */
    private boolean showExceptionInTerminal;

    /**
     * Quantity of Nodes inside this data structure
     */
    private int size;

    /**
     * Class constructor
     */
    public CircularLinkedList() {
        this.size = 0;
        this.head = null;
        this.last = null;
        this.showExceptionInTerminal = false;
    }

    /**
     * Increase size of CircularLinkedList in one unity
     */
    private void increaseSize() {
        this.size++;
    }

    /**
     * Decrease size of CircularLinkedList in one unity
     */
    private void decreaseSize() {
        this.size--;
    }

    /**
     * @return Quantity of items are stored inside CircularLinkedList
     */
    public int getSize() {
        return size;
    }

    /**
     * Create Node instance 
     * 
     * @param data Information to store inside the Node
     * @return {@code Node} instance with data stored inside
     */
    private Node createNewNode(int data) {
        this.increaseSize();
        return new Node(data);
    }

    /**
     * Insert new Node in the last posisition
     * 
     * @param data Information to store inside the Node
     */
    public void insertLast(int data) {
        Node newNode = createNewNode(data);

        if (this.head == null) {
            this.head = newNode;
            this.last = newNode;
            return;
        }

        this.last.setNext(newNode);
        newNode.setNext(this.head);
        this.last = newNode;
    }

    /**
     * Show all data inside CircularlinkedList
     * 
     * @param infinity true if want to show infinity chain passing last node to head every time
     */
    public void transversal(boolean infinity) {
        Node temp = this.head;

        Node lastNode = infinity ? null : this.last;

        while (temp != lastNode) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }

        //Last Node in case of infinty variable set to  false
        System.out.println(temp.getData());
    }

    /**
     * Find first Node with data stored inside
     * 
     * @param data Information stored inside Node
     * @throws Exception indicating Node was not found inside CircularLinkedList
     * @return {@code Node} Instance 
     */
    private Node getNode(int data) throws Exception {
        if (this.head.getData() == data) return this.head;
        
        Node temp = this.head;
        
        while (temp != this.last) {
            if (temp.getData() == data) return temp;
            temp = temp.getNext();
        }

        //In case of be last Node
        if (temp.getData() == data) return this.last;

        throw new Exception("Node with value " + data + " was not found inside CircularLinkedList");
    }

    /**
     * Insert new {@code Node} after first existed {@code Node} with value
     * 
     * @param existedData Value already stored inside a {@code Node}
     * @param data Value to stored inside a {@code Node}
     */
    public void insertAfter(int existedData, int data) {
        Node newNode = createNewNode(data);

        try {
            Node foundNode = this.getNode(existedData);

            if (foundNode == this.last) {
                foundNode.setNext(this.last.getNext());
                this.last.setNext(newNode);
                this.last = newNode;
                return;
            }

            newNode.setNext(foundNode.getNext());
            foundNode.setNext(newNode);
        } catch (Exception e) {
            this.log(e);
        }
    }

    /**
     * Insert {@code Node} at the first position
     * 
     * @param data Value to store inside the {@code Node}
     */
    public void insertFirst(int data) {
        Node newNode = createNewNode(data);

        newNode.setNext(this.head);
        this.last.setNext(newNode);
        this.head = newNode;
    }

    /**
     * Get first {@cod Node} preview search {@Node}
     * 
     * @param data Inforation stored inside the {@code Node}
     * @throws Exception when no {@code Node} contain data stored inside
     * @return Preview {@code Node} that contain data stores inside
     */
    private Node getPreview(int data) throws Exception {
        if (this.head.getData() == data) return this.last;

        Node temp = this.head;

        while (temp != this.last) {
            if (temp.getNext().getData() == data) return temp; 
            temp = temp.getNext();
        }

        throw new Exception("No Node was found with value " + data + " inside CircularLinkedList");
    }

    /**
     * Delete first {@code Node} that contain data stored inside
     * 
     * @param data Number stored inside the Node
     */
    public void delete(int data) {
        this.decreaseSize();

        try {
            Node previewNode = this.getPreview(data);

            Node nodeToDelete = previewNode.getNext();

            if (nodeToDelete == this.head) {
                Node headNode = this.head;
                this.head = this.head.getNext();
                this.last.setNext(this.head);
                headNode.setNext(null);
                return;
            }

            if (nodeToDelete == this.last) {
                Node lastNode = this.last;
                previewNode.setNext(this.last.getNext());
                this.last = previewNode;
                lastNode.setNext(null);
                return;
            }

            previewNode.setNext(nodeToDelete.getNext());
            nodeToDelete.setNext(null);
        } catch (Exception e) {
            this.log(e);
        }
    }

    /**
     * Log message in case of errors. Easy if we want to create a file to store all Exceptions logs
     * 
     * @param e Exception to log data
     */
    private void log(Exception e) {
        if (this.showExceptionInTerminal) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}