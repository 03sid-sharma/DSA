import java.util.NoSuchElementException;

class Main{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(100);
        list.addLast(200);
        list.addLast(300);
        list.addLast(400);
        list.removeLast();
        System.out.println(list.contains(200));

    }
}

public class LinkedList {
    private class Node{
        private Node next;
        private int value;

        private Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public void removeFirst(){
        if(isEmpty())   
        throw new NoSuchElementException();
        
        if(first == last){
            first = last = null;
            return;
        }
        
        var second = first.next;
        first.next = null;
        first = second;
    }

    public void removeLast(){
        if (isEmpty())
            throw new NoSuchElementException();
        
        if(first == last){
            first = last = null;
            return;
        }

        var previous = getPreviousNode(last);
        last = previous;
        last.next = null;
        
    }

    private Node getPreviousNode(Node node) {
        var current = first;
        while (current != null) {
            if(current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public void addLast(int value){
        Node node = new Node(value);
        if(isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
    }

    public int indexOf(int item){
        int index = 0;
        var current = first;
        while (current != null) {
            if(current.value == item)
                return index;
            current = current.next;
        index++;
        }
        return -1;
    }

    public void addFirst(int value){
        Node node = new Node(value);
        if(isEmpty()) 
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }
}
