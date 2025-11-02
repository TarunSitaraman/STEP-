
public class LinearQueue {

    private int[] queue;
    private int front, rear, capacity;

    public LinearQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    // Check if queue is full
    public boolean isFull() {
        return rear == capacity - 1;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front > rear;
    }

    // Add element to queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        queue[++rear] = item;
        System.out.println("Enqueued " + item);
    }

    // Remove element from queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // or throw exception
        }
        int item = queue[front++];
        System.out.println("Dequeued " + item);
        return item;
    }

    // Peek front element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1; // or throw exception
        }
        return queue[front];
    }

    public static void main(String[] args) {
        LinearQueue q = new LinearQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front element is: " + q.peek());

        q.dequeue();
        q.dequeue();

        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.enqueue(70);  // Should print queue full message

        while (!q.isEmpty()) {
            q.dequeue();
        }
    }
}
