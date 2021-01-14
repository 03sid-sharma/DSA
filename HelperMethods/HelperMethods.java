import java.math.*;

public class HelperMethods {
    public static void main(String[] args) {
        
        // For ODD EVEN
        int num=12;
        System.out.println((num & 1) == 0 ? "EVEN" : "ODD");

        // For No.of Digits
        int n = 12345;
        int dig = (int) Math.floor(Math.log10(n)) + 1;
        System.out.println(dig);
        
        // For Prime numbers
        BigInteger a = BigInteger.valueOf(3);
        System.out.println(a.isProbablePrime(1));

        // For GCD
        BigInteger b = BigInteger.valueOf(5);
        System.out.println(a.gcd(b));

        // Swapping two numbers
        int num1=10,num2=20;
        num1 ^= num2;
        num2 ^= num1;
        num1 ^= num2;
        System.out.println(num1+" "+num2);

    }
}
