import java.util.ArrayDeque;
import java.util.Arrays;
// import java.util.Queue;
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
        // reverse(queue);
        // System.out.println(queue);

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

        StackQueue sq = new StackQueue();
        sq.enqueue(10);
        sq.enqueue(20);
        sq.enqueue(30);
        System.out.println(sq.dequeue());
    }

    // public static void reverse(Queue<Integer> queue){
    //     Stack<Integer> stack = new Stack<>();
    //     while (!queue.isEmpty()) 
    //         stack.push(queue.remove());
        
    //     while (!stack.isEmpty()) 
    //         queue.add(stack.pop());
    // }
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