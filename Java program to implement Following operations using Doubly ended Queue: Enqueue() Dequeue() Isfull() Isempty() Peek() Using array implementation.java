public class DoublyEndedQueue {
    private int maxSize;
    private int[] dequeArray;
    private int front;  // Front of the deque
    private int rear;   // Rear of the deque
    private int size;   // Current size of the deque

    public DoublyEndedQueue(int maxSize) {
        this.maxSize = maxSize;
        this.dequeArray = new int[maxSize];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueueFront(int data) {
        if (!isFull()) {
            if (isEmpty()) {
                front = 0;
                rear = 0;
            } else if (front == 0) {
                front = maxSize - 1;
            } else {
                front--;
            }
            dequeArray[front] = data;
            size++;
        } else {
            System.out.println("Deque is full. Cannot enqueue at the front.");
        }
    }

    public void enqueueRear(int data) {
        if (!isFull()) {
            if (isEmpty()) {
                front = 0;
                rear = 0;
            } else if (rear == maxSize - 1) {
                rear = 0;
            } else {
                rear++;
            }
            dequeArray[rear] = data;
            size++;
        } else {
            System.out.println("Deque is full. Cannot enqueue at the rear.");
        }
    }

    public int dequeueFront() {
        if (!isEmpty()) {
            int data = dequeArray[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (front == maxSize - 1) {
                front = 0;
            } else {
                front++;
            }
            size--;
            return data;
        } else {
            System.out.println("Deque is empty. Cannot dequeue from the front.");
            return -1;
        }
    }

    public int dequeueRear() {
        if (!isEmpty()) {
            int data = dequeArray[rear];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (rear == 0) {
                rear = maxSize - 1;
            } else {
                rear--;
            }
            size--;
            return data;
        } else {
            System.out.println("Deque is empty. Cannot dequeue from the rear.");
            return -1;
        }
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peekFront() {
        if (!isEmpty()) {
            return dequeArray[front];
        } else {
            System.out.println("Deque is empty. Cannot peek at the front.");
            return -1;
        }
    }

    public int peekRear() {
        if (!isEmpty()) {
            return dequeArray[rear];
        } else {
            System.out.println("Deque is empty. Cannot peek at the rear.");
            return -1;
        }
    }

    public static void main(String[] args) {
        DoublyEndedQueue deque = new DoublyEndedQueue(5);

        deque.enqueueFront(1);
        deque.enqueueRear(2);
        deque.enqueueFront(3);
        deque.enqueueRear(4);

        System.out.println("Front: " + deque.peekFront());
        System.out.println("Rear: " + deque.peekRear());

        while (!deque.isEmpty()) {
            System.out.print(deque.dequeueFront() + " ");
        }
    }
}
