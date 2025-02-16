
/**
 * Double linked list representation
 * 
 * @author Richard Guilherme
 */
public class DoubleLinkedList {

    /**
     *  First Node
     */
    private Node head;

    /**
     * Last Node
     */
    private Node last;

    /**
     * Size of Data Struture
    */
    private int size;

    /**
     * Class constructor
     */
    public DoubleLinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Increase size in 1 unity
     */
    private void increaseSize() {
        this.size++;
    }

    /**
     * Decrease size in 1 unity 
     * */
    private void decreaseSize() {
        this.size--;
    }

    /**
     * @return Size of datastructure
     */
    public int getSize() {
        return this.size;
    }

    /**
     * @param data Decimal number to store inside node
     * @return New Node address with data value stored inside
     */
    private Node createNode(int data) {
        return new Node(data);
    } 

    /**
     * Insert a new node at the final position of the double linked list
     * @param data Information to store inside the Node
     */
    public void insertLast(int data) {
        this.increaseSize();
        Node newNode = createNode(data);

        if (this.head == null) {
            this.head = newNode;
            this.last = newNode;
            return;
        }

        this.last.setNext(newNode);
        newNode.setPreview(this.last);
        this.last = newNode;
    }

    /**
     * Insert a new node at the first of double linked list
     * 
     * @param data Information to store inside the node
     */
    public void insertBegin(int data) {
        this.increaseSize();
        Node newNode = createNode(data);
        
        if (this.head == null) {
            this.head = newNode;
            this.last = newNode;
            return;
        }

        newNode.setNext(this.head);
        this.head.setPreview(newNode);
        this.head = newNode;
    }

    /**
     * Show all values stored from the first to last
     * 
     * @param reverse true to show node datas from the last to head
     */
    public void transversal(boolean reverse) {
        Node temp = reverse ? this.last : this.head;

        while (temp != null) {
            System.out.println(temp.getData());
            temp = reverse ? temp.getPreview() : temp.getNext();
        }
    }

    /**
     * @param data Information stored inside one Node
     * @return First Node instance with data value stored inside
     * @throws Exception If no Node has data stored inside 
     */
    private Node getNode(int data) throws Exception {
        Node temp = this.head;

        while (temp != null) {
            if (temp.getData() == data) return temp;
            temp = temp.getNext();
        }

        throw new Exception("Node with value " + data + " was not found inside the Data structure");
    }

    /**
     * Insert new node after a Node with a value stored inside
     * 
     * @param existedData value of existed Node
     * @param data Info to store inside the new Node
     */
    public void insertAfter(int existedData, int data) {
        try {
            Node foundNode = this.getNode(existedData);

            Node newNode = this.createNode(data);
            newNode.setNext(foundNode.getNext());

            foundNode.getNext().setPreview(newNode);
            foundNode.setNext(newNode);

            newNode.setPreview(foundNode);

            this.increaseSize();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete a Node inside data structure
     * 
     * @param data Information stored inside the Node
     */
    public void delete(int data) {
        if (this.head.getData() == data) {
            this.head = this.head.getNext();

            this.head.getPreview().setNext(null);
            this.head.setPreview(null);

            this.decreaseSize();
            return;
        }

        try {
            Node foundNode = this.getNode(data);

            if (foundNode == this.last) {
                this.last = foundNode.getPreview();
                foundNode.setPreview(null);   
                this.last.setNext(null);
                this.decreaseSize();
                return;
            }

            Node previewNode = foundNode.getPreview();
            previewNode.setNext(foundNode.getNext());

            foundNode.getNext().setPreview(foundNode.getPreview());

            foundNode.setNext(null);
            foundNode.setPreview(null);
            this.decreaseSize();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}