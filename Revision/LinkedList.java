import java.util.Arrays;
import java.util.NoSuchElementException;

class Main{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // list.addLast(100);
        // list.addLast(200);
        // list.addLast(300);
        // list.addLast(400);
        var ll = list.createWithLoop();
        System.out.println(ll.hasLoop());
        // list.removeLast();
        // list.reverse();
        // list.printMiddle();
        // System.out.println(list.contains(200));
        // System.out.println(list.size());
        // System.out.println(list.getKthNodeFromEnd(2));
        // System.out.println(Arrays.toString(list.toArray()));
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
    private int size;

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public boolean hasLoop(){
        var slow = first;
        var fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
                return true;
        }
        return false;
    }

    public LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }
    
    public void printMiddle(){
        var a = first;
        var b = first;

        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }

        if(b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + "," + a.next.value);

    }

    public void reverse(){
        if(isEmpty()) return;

        var previous = first;
        var current = first.next;
        while(current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthNodeFromEnd(int k){
        if(isEmpty()) 
            throw new IllegalStateException();

        var a = first;
        var b = first;
        for (int i = 0; i < k-1; i++) {
            b = b.next;
            if(b == null) 
                throw new IllegalArgumentException();
        }

        while(b != last){
            a=a.next;
            b=b.next;
        }
        return a.value;
    }

    public int[] toArray(){
        int arr[] = new int[size];
        var current = first;
        var index = 0;
        while(current != null){
            arr[index++] = current.value;
            current = current.next;
        }
        return arr;
    }

    public void removeFirst(){
        if(isEmpty())   
            throw new NoSuchElementException();
        
        if(first == last){
            first = last = null;
        }else{
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast(){
        if (isEmpty())
            throw new NoSuchElementException();
        
        if(first == last){
            first = last = null;
        }else{
            var previous = getPreviousNode(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    private Node getPreviousNode(Node node) {
        var current = first;
        while (current != null) {
            if(current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public void addAtIndex(int item, int position) {
        Node node = new Node(item);
        Node current = first;
        int index = 0;
        while (current != null) {
            if (index == position - 1) {
                Node temp = current.next;
                current.next = node;
                node.next = temp;
            }
            current = current.next;
            index++;
        }
    }

    public void addLast(int value){
        Node node = new Node(value);
        if(isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public int size(){
        return size;
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
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
