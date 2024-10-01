package com.pluralsight;
import java.util.*;

public class financial_calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        double loanAmount = promptUserForValues("Enter loan amount: $");
        double interestAmount = promptUserForValues("Enter interest rate: ");
        double loanLength = promptUserForValues("Enter loan length: ");

        displayMonthlyPayment(loanAmount, interestAmount, loanLength);
    }

    public static double promptUserForValues(String prompt){

        System.out.print(prompt);

        return scanner.nextDouble();
    }

    public static double getTotalInterest(double monthlyPayment, double length, double loan){
        double totalPayments = monthlyPayment * (length*12);

        return  totalPayments - loan;
    }

    public static double displayMonthlyPayment(double loan, double interest, double length){
        interest = (interest/100) / 12;
        double paymentFormula = loan * ((interest*Math.pow(1+interest,length*12))/(Math.pow(1+interest,length*12)-1));
        System.out.println("A " + String.format("%.2f" , loan) + " loan at " + interest*100*12 + "% interest for " + length + " years would have a $" + String.format("%.2f", paymentFormula) + "/mo payment with a total interest of $"+ String.format("%.2f",getTotalInterest(paymentFormula,length,loan)));

        return paymentFormula;
    }
}
