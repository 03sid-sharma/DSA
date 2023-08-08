import java.util.*;

class Main{
    public static void main(String[] args) {
        // StringReverser str = new StringReverser();
        // System.out.println(str.reverse(null));
        // System.out.println(str.balancedExpr("{p[0-<0->]}"));
        Stck stck = new Stck();
        stck.push(10);
        stck.push(20);
        stck.push(30);
        stck.push(40);
        stck.pop();
        System.out.println(stck.isEmpty());

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
        return true;
    }
}