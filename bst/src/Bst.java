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

    public int size(){
        return size(root);
    }

    public int size(Node<T> root){
        if(root==null) return 0;

        return size(root.left)+size(root.right)+1;
    }

    public boolean search(T data){
        return searchData(root,data);
   }

   public boolean searchData(Node<T> root, T data){
       if(root==null) return false;
       if(root.data.compareTo(data)==0) return true;

       if(data.compareTo(root.data) < 0){
           return searchData(root.left,data);
       } else {
           return searchData(root.right,data);
       }
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

        bst.insert(22);
        bst.insert(40);
        bst.insert(60);
        bst.insert(95);
        bst.insert(11);
        bst.insert(65);
        bst.insert(3);
        bst.insert(16);
        bst.insert(63);
        bst.insert(67);

        System.out.println(bst.size());

        System.out.println("Search 63: "+bst.search(63));
        System.out.println("Search 64: "+bst.search(64));

    }
}
