import java.text.NumberFormat;
import java.util.*;

/**
 * MortgageCalculator
 */
public class MortgageCalculator {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = scan.nextInt();
        
        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scan.nextFloat();
        
        System.out.print("Period (Years): ");
        byte years = scan.nextByte();
        
        printMortgage(principal, annualInterestRate, years);
        printPaymentSchedule(principal, annualInterestRate, years);
        scan.close();
    }

    private static void printMortgage(int principal, float annualInterestRate, byte years) {
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(calculateMortgage(principal,annualInterestRate,years)));
    }

    private static void printPaymentSchedule(int principal, float annualInterestRate, byte years) {
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            System.out.println(NumberFormat.getCurrencyInstance().format(calculateBalance(principal, annualInterestRate, years, month)));
        }
    }

    public static double calculateBalance(
            int principal,
            float annualInterestRate,
            byte years,
            short numberOfPaymentsMade){
        
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        return principal * (Math.pow(1 + monthlyInterestRate, numberOfPayments)
                - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }

    public static double calculateMortgage(
            int principal,
            float annualInterestRate,
            byte years) {

        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / ((Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1));
    }
}