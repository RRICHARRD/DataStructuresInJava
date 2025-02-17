
public class Main {
    public static void main(String[] args) {
        
        Queue queue = new Queue(5);

        queue.enqueue(10); 
        queue.enqueue(11); 
        queue.enqueue(12); 
        queue.enqueue(13); 
        queue.enqueue(14); 

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(15);
        queue.enqueue(16);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.show();
    }
}