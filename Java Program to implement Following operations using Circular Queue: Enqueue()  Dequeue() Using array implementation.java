public class CircularQueue {
    private int maxSize;
    private int[] queueArray;
    private int front; // Front of the queue
    private int rear;  // Rear of the queue
    private int size;  // Current size of the queue

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
        } else {
            if (isEmpty()) {
                front = 0;
                rear = 0;
            } else {
                rear = (rear + 1) % maxSize; // Circular queue
            }
            queueArray[rear] = data;
            size++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        } else {
            int data = queueArray[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % maxSize; // Circular queue
            }
            size--;
            return data;
        }
    }

    public boolean isFull() {
        return (front == 0 && rear == maxSize - 1) || (front == rear + 1);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Front: " + queue.queueArray[queue.front]);

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
