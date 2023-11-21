class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public void preorderTraversal() {
        preorderTraversalRec(root);
        System.out.println();
    }

    private void preorderTraversalRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversalRec(root.left);
            preorderTraversalRec(root.right);
        }
    }

    public void postorderTraversal() {
        postorderTraversalRec(root);
        System.out.println();
    }

    private void postorderTraversalRec(Node root) {
        if (root != null) {
            postorderTraversalRec(root.left);
            postorderTraversalRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void inorderTraversal() {
        inorderTraversalRec(root);
        System.out.println();
    }

    private void inorderTraversalRec(Node root) {
        if (root != null) {
            inorderTraversalRec(root.left);
            System.out.print(root.data + " ");
            inorderTraversalRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder Traversal:");
        bst.inorderTraversal();

        System.out.println("Preorder Traversal:");
        bst.preorderTraversal();

        System.out.println("Postorder Traversal:");
        bst.postorderTraversal();

        bst.delete(20);
        System.out.println("Inorder Traversal after deleting 20:");
        bst.inorderTraversal();
    }
}
