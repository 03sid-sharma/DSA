import java.util.ArrayList;

class TreesRevise{
    public static void main(String[] args) {
        Trees bst = new Trees();
        // Insert in BST
        bst.insert(7);
        bst.insert(4);
        bst.insert(9);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(10);

        // BFS
        bst.traverseLevelOrder();

        // Node at K distance
        // ArrayList<Integer> list = bst.getNodesAtDistance(1);
        // for (int item : list)
        //     System.out.print(item + " ");

        // bst.swapRoot();
        // System.out.println(bst.isBinarySearchTree());
        
        // Trees bst2 = new Trees();
        // Insert in Second BST
        // bst2.insert(7);
        // bst2.insert(4);
        // bst2.insert(9);
        // bst2.insert(1);
        // bst2.insert(6);
        // bst2.insert(8);
        // bst2.insert(10);

        //Compare Trees
        // System.out.println(bst.equals(bst2));

        // Search in BST
        // System.out.println(bst.find(22));

        // DFS Traversal of BST
        // bst.traversePreOrder();
        // System.out.println();
        // bst.traverseInOrder();
        // System.out.println();
        // bst.traversePostOrder();

        // Height of BST
        // System.out.println(bst.height());

        // Minimum value of BST and BT
        // System.out.println(bst.minimumValue());
    }
}

class Trees {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        Node(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node="+value;
        }
    }

    private Node root;

    public void traverseLevelOrder() {
        for (int i = 0; i < height(); i++) {
            for (var item : getNodesAtDistance(i))
                System.out.print(item + " ");
        }
    }

    // Node at K distance 
    public ArrayList<Integer> getNodesAtDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    // For testing Valid BST
    public void swapRoot(){
        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }
    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if(root == null)
            return true;
        
        if(root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public boolean equals(Trees other){
        if(other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second){
        if(first == null && second == null)
            return true;

        if(first != null && second != null)
            return first.value == second.value
            && equals(first.leftChild,second.leftChild)
            && equals(first.rightChild,second.rightChild);

        return false;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null)
            root = node;
        else {
            var current = root;
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
    }

    public int minimumValue() {
        // If BST
        if(root == null)
            throw new IllegalStateException();
        var current = root;
        var last = root;
        while(current != null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
        // If Binary Tree
        // return minimumValue(root);
    }

    private int minimumValue(Node root) {
        if(isLeaf(root))
            return root.value;

        var left = minimumValue(root.leftChild);
        var right = minimumValue(root.rightChild);
        return Math.min(root.value, Math.min(left, right));
    }

    public boolean find(int value){
        var current = root;
        while(current != null){
            if(value < current.value)
                current = current.leftChild;
            else if(value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    public void traversePreOrder(Node root){
        if(root == null)
            return;

        System.out.print(root.value+" ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root){
        if(root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.print(root.value+" ");
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root){
        if(root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.print(root.value+" ");
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null)
            return -1;
        
        if(isLeaf(root))
            return 0;
        
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }
}
