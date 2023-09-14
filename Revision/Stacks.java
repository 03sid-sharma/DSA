import java.util.*;

class Main{
    public static void main(String[] args) {
        StringReverser str = new StringReverser();
        // System.out.println(str.reverse(null));
        System.out.println(str.balancedExpr("{{{}}}"));
        // Stck stck = new Stck();
        // stck.push(10);
        // stck.push(20);
        // stck.push(30);
        // stck.push(40);
        // stck.pop();
        // System.out.println(stck.isEmpty());

    }
}

class Stck{
    private int arr[] = new int[5];
    private int count = 0;

    public void push(int item){
        if(count == arr.length)
            throw new StackOverflowError();
        arr[count++] = item;
    }

    public int peek(){
        if(count == 0)  
            throw new IllegalStateException();
        return arr[count - 1];
    }

    public boolean isEmpty(){
        return count ==  0;
    }

    public int pop(){
        if(count == 0) 
            throw new IllegalStateException();
        return arr[--count];
    }

    @Override
    public String toString(){
        var items = Arrays.copyOfRange(arr, 0 , count);
        return Arrays.toString(items);
    } 
    

}

class StringReverser{
    public String reverse(String str){
        if(str == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char character : str.toCharArray()) 
            stack.push(character);
        
        StringBuffer reversed = new StringBuffer();
        while (!stack.empty()) 
            reversed.append(stack.pop());

        return reversed.toString();
    }

    public boolean balancedExpr(String str){
        Stack<Character> stack = new Stack<>();
        for (Character character : str.toCharArray()) {
            if(character == '<' || character == '{' || character == '(' || character == '[')
                stack.push(character);
            
            if(character == '>' || character == '}' || character == ')' || character == ']'){
                if(stack.empty())
                    return false;

                var top = stack.pop();
                if((character == '>' && top != '<') ||
                    (character == '}' && top != '{') ||
                    (character == ')' && top != '(') ||
                    (character == ']' && top != '['))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}


// We always use queue1 for pushing new items.
// When popping an item, we move all the items
// except the last one from queue1 to queue2.
//
// Q1 [10, 20, 30, 40] => Q1 [40]
// Q2 []               => Q2 [10, 20, 30]
//
// Now the item to be popped is in Q1. We remove
// and return that as the item on top of the stack.
//
// Q1 []
// Q2 [10, 20, 30]
//
// We should swap the queues, so we can repeat this
// algorithm next time we need to pop the stack.
//
// Q1 [10, 20, 30]
// Q2 []  (ready for moving items)

class StackWithTwoQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int top;

    // O(1)
    public void push(int item) {
        queue1.add(item);
        top = item;
    }

    // O(n)
    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }

        swapQueues();

        return queue2.remove();
    }

    private void swapQueues() {
        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // O(1)
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // O(1)
    public int size() {
        return queue1.size();
    }

    // O(1)
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return top;
    }

    @Override
    public String toString() {
        return queue1.toString();
    }
}
