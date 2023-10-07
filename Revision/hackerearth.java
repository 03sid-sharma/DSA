import java.util.*;
import java.math.*;

class hackerearth {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int number = Integer.parseInt(str);
        String ans = "";
        Stack<String> stack = new Stack<>();
        while (number != 0) {
            int num = number % 10; 
            if((num & 1) == 0){
                int high = num + 1, low = num - 1;
                stack.push(String.valueOf((Math.abs(num - high) < Math.abs(num - low)) ? high : low));
            }else{
                stack.push(String.valueOf(num));
            }
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            number /= 10; 
        }
        System.out.println(ans);
    }
}
