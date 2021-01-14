import java.util.*;

public class BalancedExp {
    public static void main(String[] args) {
        String str="{(a+b)[]<j+h{}>}";
        BExp bs=new BExp();
        System.out.println(bs.isBalanced(str));
    }
}

class BExp {
    private final List<Character> leftBrackets
    =Arrays.asList('(','{','[','<');
    private final List<Character> rightBrackets
    =Arrays.asList(')','}',']','>');
    
    public boolean isBalanced(String str){
        Deque<Character> stack=new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if(isLeftBracket(ch))
                stack.push(ch);
                
            if(isRightBracket(ch)){
                if(stack.isEmpty())
                    return false;

                var top=stack.pop();
                if(!bracketsMatch(top,ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    
    private boolean bracketsMatch(Object left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }
}