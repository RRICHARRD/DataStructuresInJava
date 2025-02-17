

/**
 * Queue data structure implemented in Array
 * 
 * @author Richard Guilherme
 * @version 1.0.0
 */
public class Queue {

    /**
     * Max items to store insite Queue 
     */
    private int fullSize;

    /**
     * Reference elements to store in the Queue
     */
    private int[] elements;

    /**
     * Current quantity of elements inside the Queue
     */
    private int currentSize;

    /**
     * Last index of array dequeued, this is important to know the last position we dequeued a value
     * because the index 0, 1 could be penultimate and last itens in that Queue if we dequeue and enqueue
     * new data again 
     */
    private int firstPosition;

    /**
     * Last position of data inserted in the queue
     */
    private int lastPosition;

    /**
     * Class constructor
     */
    public Queue(int fullSize) {
        this.currentSize = 0;
        this.lastPosition = -1;
        this.fullSize = fullSize;
        this.firstPosition = 0;
        this.elements = new int[fullSize];
    }

    /**
     * @return Current quantity of items queued
     */
    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * @return Max size of items to store inside queue
     */
    public int getFullSize() {
        return fullSize;
    }

    /**
     * @return Last possible position of the array
     */
    private int getLastPossiblePositionOfStackArray() {
        return this.fullSize - 1;
    }

    /**
     * @return True if queue does not have value
     */
    private boolean isEmpty() {
        return this.currentSize == 0;
    }

    /**
     * @return true if queue if full
     */
    private boolean isFull() {
        return this.currentSize == this.fullSize;
    }

    /**
     * Increase size of the stack, this size indicates how many itens the stack has
     */
    private void increaseStackSize() {
        this.currentSize++;
    }

    /**
     * Decrease size of the stack, this size indicates how many itens the stack has
     */
    private void decreaseStackSize() {
        this.currentSize--;
    }

    /**
     * Queue element
     * 
     * @hidden Pay attention, how Java works:
     * int positionToEnqueue = this.lastPosition + 1 will create a copy of this.lastPosition in a new variable and sum 1 and after that pass the value to positionToEnqueue, this.lastPosition in that case will NEVER CHANGE IN CLASS INSTANCE 
     * int positionToEnqueue = this.lastPosition++ will pass the current value of this.lastPosition to positionToEnqueueu and after that will increment the varible instance, in that case positionToEnqueue will NEVER STORE THE LAST UPDATED VALUE
     * int positionToEnqueue = ++this.lastPosition; will update this.lastPosition in the instance and after that copy the value to var positionToEnqueue, so, positionToEnqueue in that case will alwayes store updated value after increment
     * 
     * @param data Information to queue
     */
    public void enqueue(int data) {
        if (this.isFull()) return;

        int nextPositionToEnqueue = ++this.lastPosition;
        
        if (this.lastPosition > this.getLastPossiblePositionOfStackArray()) {
            this.lastPosition = 0; //Reseting position to store in the first index again
            nextPositionToEnqueue = 0;
        }
        
        this.elements[nextPositionToEnqueue] = data;
        
        this.increaseStackSize();
    }

    /**
     * @return The first element inserted in the queue
     */
    public int dequeue() {
        if (this.isEmpty()) {
            return -1;
        }

        if (this.firstPosition > this.getLastPossiblePositionOfStackArray()) {
            this.firstPosition = 0;
        } 
        
        int firstPositionToDequeue = this.firstPosition;
        int dataDequeued = this.elements[firstPositionToDequeue];
        
        this.decreaseStackSize();
        this.firstPosition++;

        return dataDequeued;
    }
    
    /**
     * Show queuen from the first to last
     */
    public void show() {
        if (this.isEmpty()) return;

        if (this.currentSize == 1) {
            System.out.println(this.elements[firstPosition]);
            return;
        }


        int actualIndexPosition = this.firstPosition;
        
        while (actualIndexPosition != this.lastPosition) {
            if (actualIndexPosition > this.getLastPossiblePositionOfStackArray()) {
                actualIndexPosition = 0;
            }

            System.out.println(this.elements[actualIndexPosition]);
            actualIndexPosition++;
        }

        System.out.println(this.elements[this.lastPosition]);
    }
    
}