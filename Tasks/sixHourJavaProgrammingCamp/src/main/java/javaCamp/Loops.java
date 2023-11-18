package javaCamp;

public class Loops {
    public static void main(String[] args) {
        String product = "Laptop";
        for (int i = 1; i <= 10; i++) {
            System.out.println(product + i);

        }

        System.out.println("----------");

        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i);
        }

        System.out.println("----------");

        int number = 10;
        while (number < 100) {
            System.out.println(number);
            number += 10;
        }

        System.out.println("----------");

        int number2 = 11;
        do {
            System.out.println(number2);
            number2 += 10;
        } while (number2 > 100);
    }
}
