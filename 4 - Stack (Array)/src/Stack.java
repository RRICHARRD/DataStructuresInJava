

/**
 * Stack datastructure implemented using Arrays
 * 
 * @author Richard Guilherme
 * @version 1.0.0
 */
public class Stack {

    /**
     * Max quantity of items to store in the Stack
     */
    private int fullSize;

    /**
     * Reference to store an array of elements
     */
    private int[] elements;

    /**
     * Quantity of itens stored in the stack
     */
    private int currentSize;

    /**
     * Class constructor
     */
    public Stack(int fullSize) {
        this.currentSize = 0;
        this.fullSize = fullSize;
        this.elements = new int[fullSize];
    }

    /**
     * @return Full size of Stack
     */
    public int getFullSize() {
        return fullSize;
    }

    /**
     * @return Quantity of elements was stores inside the stack
     */
    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * Insert a new value inside the Stack
     * @param data Info to store inside the stack
     */
    public void push(int data) {
        
        if (this.currentSize == this.fullSize) {
            try {
                throw new Exception("Stack is fully filled!");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return;
            }
        }

        this.elements[this.currentSize] = data;
        this.currentSize++;
    }


    /**
     * Show elements in the stack from the top to bottom
     */
    public void show() {
        int position = this.currentSize - 1;

        while (position != -1) {
            System.out.println(this.elements[position]);
            position--;
        }
    }

    /**
     * Remove last inserted element
     * 
     * @hidden Using Nodes is better here because I can return null if there are no elements to pop
     */
    public int pop() {
        int currentItem = this.elements[this.currentSize-1];
        this.currentSize--;
        return currentItem;
    }
}