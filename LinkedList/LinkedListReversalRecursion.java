class Main{
    public static void main(String[] args) {
        ListReversal list = new ListReversal();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        list.reverse(null,list.first);
        list.print();
    }
}

class ListReversal{

    private class Node{
        private Node next;
        private int value;
        private Node(int value){
            this.value=value;
        }       
    }
    public Node first;
    public Node last;
    
    public void reverse(Node previous, Node current){
        if (current!=null){
            reverse(current, current.next);
            current.next=previous;
        }else{
        first=previous;
        }
    }
    
    public void addLast(int item){
        Node node=new Node(item);

        if(isEmpty())
            first=last=node;
        else{
            last.next=node;
            last=node;
        }
    }

    public void print(){
        var current=first;
        
        while(current!=null){
            System.out.print(current.value+" ");
            current=current.next;
        }
    }

    private boolean isEmpty() {
        return first==null;
    }
}