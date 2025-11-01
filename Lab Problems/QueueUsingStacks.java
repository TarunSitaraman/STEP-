
import java.util.Stack;

public class QueueUsingStacks {

    private Stack<Integer> stackEnqueue;
    private Stack<Integer> stackDequeue;

    public QueueUsingStacks() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    // Enqueue operation (push into stackEnqueue)
    public void enqueue(int item) {
        stackEnqueue.push(item);
    }

    // Dequeue operation (pop from stackDequeue)
    public int dequeue() {
        if (stackDequeue.isEmpty()) {
            // Transfer elements from stackEnqueue to stackDequeue if stackDequeue is empty
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        if (stackDequeue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stackDequeue.pop();
    }

    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue()); // 10
        System.out.println("Dequeued: " + queue.dequeue()); // 20

        queue.enqueue(40);

        System.out.println("Dequeued: " + queue.dequeue()); // 30
        System.out.println("Dequeued: " + queue.dequeue()); // 40

        System.out.println("Is queue empty? " + queue.isEmpty()); // true
    }
}
