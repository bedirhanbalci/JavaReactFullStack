package org.example;

public class Main {
    public static void main(String[] args) {

        FourTransactions fourTransactions = new FourTransactions();
        int result1 = fourTransactions.sum(3, 4);
        System.out.println(result1);

        int result2 = fourTransactions.subtract(8, 2);
        System.out.println(result2);

        int result3 = fourTransactions.multiply(5, 7);
        System.out.println(result3);

        int result4 = fourTransactions.divide(20, 4);
        System.out.println(result4);
    }
}