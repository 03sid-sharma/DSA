import java.util.Stack;

class Main{
    public static void main(String[] args) {
        StringReverser str = new StringReverser();
        System.out.println(str.reverse(null));
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
}