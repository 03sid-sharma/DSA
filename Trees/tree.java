class MainTree {
    public static void main(String[] args) {
        Tree binaryTree= new Tree();
        binaryTree.insert(7);
        binaryTree.insert(4);
        binaryTree.insert(9);
        binaryTree.insert(1);
        binaryTree.insert(6);
        binaryTree.insert(8);
        binaryTree.insert(10);
        System.out.println(binaryTree.find(11));
    }
}
class Tree {
    private class Node{
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

    public void insert(int value){
        Node node=new Node(value);

        if(root==null){
            root=node;
            return;
        }

        Node current=root;
        
        while(true){
            if(value<current.value){
                if(current.leftChild==null){
                    current.leftChild=node;
                    break;
                }
                current=current.leftChild;
            }else
            {
                if(current.rightChild==null){
                    current.rightChild=node;
                    break;
                }
                current=current.rightChild;
            }
        }
    }
    
    public boolean find(int value){
        Node current=root;
        while(current!=null){
            if(value<current.value)
                current=current.leftChild;
            else if(value>current.value)
                current=current.rightChild;
            else
                return true;
        }
        return false;
    }
}
