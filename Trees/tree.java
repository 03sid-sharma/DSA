class MainTree {
    public static void main(String[] args) {
        Tree binaryTree = new Tree();
        binaryTree.insert(7);
        binaryTree.insert(4);
        binaryTree.insert(9);
        binaryTree.insert(1);
        binaryTree.insert(6);
        binaryTree.insert(8);
        binaryTree.insert(10);

        // System.out.println(binaryTree.find(11));
        // binaryTree.traversePreOrder();
        // binaryTree.traverseInOrder();
        // binaryTree.traversePostOrder();
        // System.out.println(binaryTree.height());
        // System.out.println(binaryTree.min());
        // System.out.println(binaryTree.max());
        // System.out.println(binaryTree.minBST());
        System.out.println(binaryTree.maxBST());
    }
}

class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node =" + value;
        }

    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        Node current = root;

        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    // O(log n)
    public int minBST() {
        if (root == null)
            throw new IllegalStateException("root must not be null");

        Node current = root;
        Node last = current;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public int min(){
        return min(root);
    }

    // O(n)
    private int min(Node root) {
        if (root == null)
            throw new IllegalStateException("root must not be null");

        if (isLeaf(root))
            return root.value;

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    // O(log n)
    public int maxBST() {
        if (root == null)
            throw new IllegalStateException("root must not be null");

        Node current = root;
        Node last = current;

        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last.value;
    }

    public int max(){
        return max(root);
    }

    // O(n)
    private int max(Node root) {
        if (root == null)
            throw new IllegalStateException("root must not be null");

        if (isLeaf(root))
            return root.value;

        int left = max(root.leftChild);
        int right = max(root.rightChild);

        return Math.max(Math.max(left, right), root.value);
    }

    private boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }
}
