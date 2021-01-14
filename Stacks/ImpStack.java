import java.util.*;

public class ImpStack {
    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(10);
        stack.push(20);
        stack.pop();
        stack.push(30);
        System.out.println(stack.peek());
    }
}

class Stack{
    private int items[]=new int[5];
    private int count;
    public void push(int item){
        if(isFull())
            throw new StackOverflowError();
        items[count++]=item;
    } 
    public int pop(){
        if (isEmpty())
            throw new IllegalStateException();
        return items[count--];
    } 
    @Override
    public String toString(){
        var content=Arrays.copyOfRange(items,0,count);
        return Arrays.toString(content);
    }
    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        return items[count-1];
    } 
    public boolean isEmpty(){
        return count==0;
    }
    public boolean isFull(){
        return count==items.length;
    } 
}