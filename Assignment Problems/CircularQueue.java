
public class CircularQueue {

    private int[] queue;
    private int front, rear, size;

    public CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Check if queue is full
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Insert element into queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = item;
        System.out.println("Enqueued: " + item);
    }

    // Delete element from queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Or throw exception
        }
        int item = queue[front];
        if (front == rear) {
            // Queue has only one element, reset after deletion
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        System.out.println("Dequeued: " + item);
        return item;
    }

    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.display();

        cq.dequeue();
        cq.dequeue();
        cq.display();

        cq.enqueue(50);
        cq.enqueue(60);
        cq.enqueue(70);  // This should show queue is full
        cq.display();
    }
}
