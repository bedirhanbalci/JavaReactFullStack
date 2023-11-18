package org.example;

public class Main {
    public static void main(String[] args) {

        FourTransaction fourTransaction = new FourTransaction();
        System.out.println(fourTransaction.sum(2, 3));
        System.out.println(fourTransaction.sum(2, 3, 5));
    }
}