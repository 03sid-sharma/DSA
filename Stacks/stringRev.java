import java.util.*;

class stack {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        StringReverser ssr=new StringReverser();
        System.out.println(ssr.reverse(str));
        // int size=0;
        // Stack<Character> stack=new Stack<>();
        // for(int i=0;i<str.length();i++){
        //     stack.push(str.charAt(i));
        //     size++;
        // }
        // for(int i=0;i<size;i++){
        //     System.out.print(stack.pop());
        // }
        scan.close();  
    }
}
class StringReverser {
    public String reverse(String str){
        if(str==null)
            throw new IllegalArgumentException();

        Stack stack=new Stack();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        StringBuffer reversed=new StringBuffer();
        
        while(!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
    
}