class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueUsingLinkedList {
    private Node front;
    private Node rear;

    public QueueUsingLinkedList() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int data = front.data;
            front = front.next;
            return data;
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int peek() {
        if (!isEmpty()) {
            return front.data;
        } else {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front: " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
