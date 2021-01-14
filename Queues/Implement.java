import java.util.*;

/**
 * Implement
 */
public class Implement {

    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(99);
        queue.enqueue(99);

        queue.deque();
        queue.enqueue(99);
        
         queue.deque();
         queue.enqueue(99);
        // var front=queue.deque();
        // System.out.println(front);

        
        System.out.println(queue);
    }
}

/**
 * ArrayQueue
 */
class ArrayQueue {
    private int items[];
    private int front,rear,count;
    public ArrayQueue(int capacity){
        items=new int[capacity];
    }
    public void enqueue(int item){
        if (isFull())
            throw new IllegalStateException();
        items[rear]=item;
        rear=(rear+1) % items.length;
        count++;
    }
    
    public int deque(){
        if(isEmpty())
            throw new IllegalStateException();
        var item=items[front];
        items[front]=0;
        front=(front+1) % items.length;
        count--;
        return item;
    }

    public boolean isEmpty(){
        return count==0;
    }

    public boolean isFull(){
        return count==items.length;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Arrays.toString(items);
    }
}