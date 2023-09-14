import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * Queue
 */
class Main {

    public static void main(String[] args) {
        // Queue<Integer> queue = new ArrayDeque<>();
        // queue.add(10);
        // queue.add(20);
        // queue.add(30);
        // queue.add(40);
        // queue.add(50);
        // reverseFirstKElements(queue, 3);
        // System.out.println(queue);
        // reverse(queue);

        // ArrrayQueue queue = new ArrrayQueue(5);
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // queue.dequeue();
        // var front = queue.dequeue();
        // queue.enqueue(40);
        // queue.enqueue(50);
        // queue.enqueue(60);
        // System.out.println(queue);
        // System.out.println(front);

        // StackQueue sq = new StackQueue();
        // sq.enqueue(10);
        // sq.enqueue(20);
        // sq.enqueue(30);
        // System.out.println(sq.dequeue());
        // PriorityQueue pq = new PriorityQueue();
        // pq.add(30);
        // pq.add(20);
        // pq.add(50);
        
        // System.out.println(pq);
        // while (!pq.isEmpty()) {
        //     System.out.println(pq.remove());
        // }

        // LinkedListQueue llq = new LinkedListQueue();
        // llq.enqueue(10);
        // llq.enqueue(20);
        // llq.enqueue(30);
        // System.out.println(llq.size());
        // llq.dequeue();
        // System.out.println(llq.peek());
        // llq.print();
    }

    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) 
            stack.push(queue.remove());
        
        while (!stack.isEmpty()) 
            queue.add(stack.pop());
    }

    public static void reverseFirstKElements(Queue<Integer> queue, int k){
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++)
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
        
        for (int index = 0; index < queue.size() - k ; index++)
            queue.add(queue.remove());
    }

}
/**
 * Queue
 */
class ArrrayQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int count;

    public ArrrayQueue(int size){
        arr = new int[size];
    }

    public void enqueue(int item){
        if(count == arr.length)
            throw new IllegalStateException();
        arr[rear] = item;
        rear = (rear + 1) % arr.length;
        count++;
    }

    public int dequeue(){
        var item = arr[front];
        arr[front] = 0;
        front = (front + 1) % arr.length;
        count--;
        return item;
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
}

class StackQueue{
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item){
        stack1.push(item);
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1To2();
        return stack2.pop();
    }

    private boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1To2();
        return stack2.peek();
    }

    private void moveStack1To2() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}

class PriorityQueue{
    private int[] arr = new int[5];
    private int count;

    public void add(int item){
        if(isFull())
            throw new IllegalStateException();

        int i = shiftItemsToInsert(item);
        arr[i] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for(i = count - 1; i >= 0; i--){
            if(arr[i] > item)
                arr[i + 1] = arr[i];
            else    
                break;
        }
        return i + 1;
    }

    private boolean isFull() {
        return count == arr.length;
    }

    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();
        return arr[--count];        
    }

    @Override
    public String toString(){
        return Arrays.toString(arr);
    }

    public boolean isEmpty() {
        return count == 0;
    }
}

class LinkedListQueue{
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public Node first;
    public Node last;
    public int count;

    public void enqueue(int item){
        Node node = new Node(item);
        if(isEmpty())  
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        count++;        
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int dequeue(){
        int value;
        if(isEmpty())
            throw new IllegalStateException();
        
        if(first == last){
            value = first.value;
            first = last = null;
        }else{
            value = first.value;
            var second = first.next;
            first.next = null;
            first = second;
        }
        count--;
        return value;
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        return first.value;
    }

    public int size(){
        return count;
    }

    public void print(){
        var current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
