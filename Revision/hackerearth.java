import java.util.*;
import java.math.*;

class hackerearth {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int arr[] = new int[n];
        int i = 0;

        while(n-- > 0)
            arr[i++] = scan.nextInt();       
        
        int wealth = 0;

        for (int j = 0; j < k; j++) {
            System.out.println("arr is " + arr[j]);
            wealth += arr[j];
        }
       
        
        System.out.println(wealth * k);
    }
}
