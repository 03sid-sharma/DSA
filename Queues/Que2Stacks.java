import java.util.Stack;

public class Que2Stacks {
    public static void main(String[] args) {
        ImpStack queue=new ImpStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        var item=queue.dequeue();
        System.out.println(item);
    }
}

class ImpStack{
    // Use deque
    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();
    
    public void enqueue(int item){
        stack1.push(item);
    }
    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();
        moveStack1ToStack2();
    
        return stack2.pop();
    }

    public boolean isEmpty(){
        return stack1.isEmpty()&&stack2.isEmpty();
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        moveStack1ToStack2();
    
        return stack2.peek();
    }
    private void moveStack1ToStack2() {
        if(stack2.isEmpty())
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
    }
    
}