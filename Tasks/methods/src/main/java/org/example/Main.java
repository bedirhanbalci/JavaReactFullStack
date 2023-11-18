package org.example;

public class Main {
    public static void main(String[] args) {
        numberFind();
    }

    public static void numberFind() {
        int[] numbers = new int[]{1, 2, 5, 7, 9, 0};
        int search = 7;
        boolean isHas = false;

        for (int number : numbers) {
            if (number == search) {
                isHas = true;
                break;
            }
        }

        String message = "";
        String message2 = "";
        if (isHas) {
            message = "Sayı mevcuttur : " + search;
            messageShow(message);
        } else {
            message2 = "Sayı mevcut değildir : " + search;
            messageShow(message2);
        }
    }

    public static void messageShow(String message) {
        System.out.println(message);
    }
}