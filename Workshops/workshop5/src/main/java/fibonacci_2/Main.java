package fibonacci_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double number = 100;

        showFibonacci(number);
    }

    public static void showFibonacci(double number) {
        double firstNumber = 0;
        double secondNumber = 1;
        double temp = 0;

        for (int i = 0; i < number; i++) {
            if (i == 0) {
                System.out.println(firstNumber);
            }
            if (i == 1) {
                System.out.println(secondNumber);
            }
            if (i > 1) {
                temp = firstNumber + secondNumber;
                firstNumber = secondNumber;
                secondNumber = temp;
                System.out.println(secondNumber);
            }
        }

    }
}
