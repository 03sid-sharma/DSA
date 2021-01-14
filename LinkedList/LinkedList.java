import java.util.*;

class Main {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        // list.addFirst(10);
        // list.addFirst(20);
        // list.addFirst(30);
        // list.addFirst(40);
        // list.addFirst(50);

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        // System.out.println(list.getKthNodeFromTheEnd(8));

        // var array=list.toArray();
        // System.out.println(Arrays.toString(array));
        
        list.reverse();
        list.print();

        // list.removeFirst();
        // list.removeLast();
        

        // System.out.println(list.indexOf(50));
        // System.out.println(list.contains(30));
        // System.out.println(list.size());
            
    }
}

class LinkedList {
    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value=value;
        }
    }
    private Node first;
    private Node last;
    private int size;
    
    public int getKthNodeFromTheEnd(int k){
        if(isEmpty())
            throw new IllegalStateException();
        var a=first;
        var b=first;
        for (int i = 0; i < k-1; i++) {
            b=b.next;
            if(b==null)
                throw new IllegalArgumentException();
        } 
        while(b!=last){
            a=a.next;
            b=b.next;
        }
        return a.value;
    }

    public void addLast(int item){
        Node node=new Node(item);
        if(isEmpty())
            first=last=node;
        else{
            last.next=node;
            last=node;
        }
        size++;
    }

    public void reverse(){
        if(isEmpty())
            return;

        var previous=first;
        var current=first.next;
        while(current!=null)
        {
            var next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        last=first;
        last.next=null;
        first=previous;
    }

    public void addFirst(int item) {
        Node node=new Node(item);
        if(isEmpty())
            first=last=node;
        else{
            node.next=first;
            first=node;
        }
        size++;
    }

    public int indexOf(int item){
        int index=0;
        var current=first;
        while(current!=null){
            if(current.value==item)
                return index;
            current=current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item)!=-1;
    }

    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first==last){
            first=last=null;
        }
        else{
            var second=first.next;
            first.next=null;
            first=second;
        }
        size--;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first==last){
            first=last=null;
        }
        else{
            var previous=getPrevious(last);
            last=previous;
            last.next=null;
        }
        size--;
    }

    public void print(){
        var current=first;
        while(current!=null){
            System.out.println(current.value);
            current=current.next;
        }
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int arr[]=new int[size];
        var current=first;
        int index=0;
        while(current!=null){
            arr[index++]=current.value;
            current=current.next;
        }
        return arr;
    }

    private Node getPrevious(Node node){
        var current=first;
        while(current!=null){
            if(current.next==node)
                return current;
            current=current.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return first==null;
    }

}