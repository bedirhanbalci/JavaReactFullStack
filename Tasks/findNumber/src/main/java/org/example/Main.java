package org.example;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 5, 7, 9, 0};
        int search = 6;
        boolean isHas = false;

        for (int number : numbers) {
            if (number == search) {
                isHas = true;
                break;
            }
        }
        if (isHas) {
            System.out.println("Sayı mevcuttur!");
        } else {
            System.out.println("Sayı mevcut değildir!");
        }
    }
}