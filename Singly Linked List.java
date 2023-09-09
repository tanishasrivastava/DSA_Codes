import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    void beginsert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value:");
        int item = sc.nextInt();
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        System.out.println("Node inserted");
    }

    void lastinsert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value:");
        int item = sc.nextInt();
        Node newNode = new Node(item);
        if (head == null) {
            newNode.next = null;
            head = newNode;
            System.out.println("Node inserted");
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = null;
            System.out.println("Node inserted");
        }
    }

    void randominsert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element value:");
        int item = sc.nextInt();
        System.out.println("Enter the location after which you want to insert:");
        int loc = sc.nextInt();
        Node newNode = new Node(item);
        Node temp = head;
        for (int i = 0; i < loc; i++) {
            temp = temp.next;
            if (temp == null) {
                System.out.println("Can't insert");
                return;
            }
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Node inserted");
    }

    void begin_delete() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node ptr = head;
            head = ptr.next;
            ptr = null;
            System.out.println("Node deleted from the beginning");
        }
    }

    void last_delete() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == null) {
            head = null;
            System.out.println("Only node of the list deleted");
        } else {
            Node ptr = head;
            Node ptr1 = null;
            while (ptr.next != null) {
                ptr1 = ptr;
                ptr = ptr.next;
            }
            ptr1.next = null;
            ptr = null;
            System.out.println("Deleted Node from the last");
        }
    }

    void random_delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the location of the node after which you want to perform deletion:");
        int loc = sc.nextInt();
        Node ptr = head;
        Node ptr1 = null;
        for (int i = 0; i < loc; i++) {
            ptr1 = ptr;
            ptr = ptr.next;
            if (ptr == null) {
                System.out.println("Can't delete");
                return;
            }
        }
        ptr1.next = ptr.next;
        ptr = null;
        System.out.println("Deleted node " + (loc + 1));
    }

    void search() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item which you want to search:");
        int item = sc.nextInt();
        Node ptr = head;
        int i = 0;
        boolean flag = false;
        while (ptr != null) {
            if (ptr.data == item) {
                System.out.println("Item found at location " + (i + 1));
                flag = true;
            }
            i++;
            ptr = ptr.next;
        }
        if (!flag) {
            System.out.println("Item not found");
        }
    }

    void display() {
        Node ptr = head;
        if (ptr == null) {
            System.out.println("Nothing to print");
        } else {
            System.out.println("Printing values...");
            while (ptr != null) {
                System.out.println(ptr.data);
                ptr = ptr.next;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 9) {
            System.out.println("\n\n*********Main Menu*********");
            System.out.println("Choose one option from the following list ...");
            System.out.println("===============================================");
            System.out.println("1. Insert in beginning");
            System.out.println("2. Insert at last");
            System.out.println("3. Insert at any random location");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from last");
            System.out.println("6. Delete node after specified location");
            System.out.println("7. Search for an element");
            System.out.println("8. Show");
            System.out.println("9. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    list.beginsert();
                    break;
                case 2:
                    list.lastinsert();
                    break;
                case 3:
                    list.randominsert();
                    break;
                case 4:
                    list.begin_delete();
                    break;
                case 5:
                    list.last_delete();
                    break;
                case 6:
                    list.random_delete();
                    break;
                case 7:
                    list.search();
                    break;
                case 8:
                    list.display();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid choice..");
            }
        }
    }
}
