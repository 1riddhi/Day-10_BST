public class Bst<T extends Comparable<T>> {
    Node<T> root;

    public Bst() {
        this.root = null;
    }

    public void insert(T data) {
        root = insertRec(root, data);
    }

    public Node<T> insertRec(Node<T> root, T data) {
        if (root == null) {
            return new Node<>(data);
        }

        if (data == null) {
            throw new IllegalArgumentException("Cannot insert null into the tree.");
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    public void inorderTraversal(Node<T> root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    public void preorderTraversal(Node<T> root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public void postorderTraversal() {
        postorderTraversal(root);
    }

    public void postorderTraversal(Node<T> root) {
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Bst<Integer> bst = new Bst<>();
        bst.insert(56);
        bst.insert(30);
        bst.insert(70);

        System.out.println("Inorder");
        bst.inorderTraversal();
        System.out.println();

        System.out.println("Preorder");
        bst.preorderTraversal();
        System.out.println();

        System.out.println("Postorder");
        bst.postorderTraversal();
        System.out.println();
    }
}
