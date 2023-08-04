import java.util.Stack;

class Main{
    public static void main(String[] args) {
        StringReverser str = new StringReverser();
        // System.out.println(str.reverse(null));

        System.out.println(str.balancedExpr("{p[0-<0->]}"));
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