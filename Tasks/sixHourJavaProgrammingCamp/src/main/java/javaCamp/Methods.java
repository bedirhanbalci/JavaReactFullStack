package javaCamp;

public class Methods {
    public static void main(String[] args) {
        showMessage("Bedirhan");
        calculate();
        System.out.println(sum(3, 6));
        System.out.println(tenPercentOfTheTwoNumbersAdded(40, 60));

    }


    public static void showMessage(String name) {
        System.out.println("Merhaba " + name);

    }

    public static void calculate() {
        System.out.println("Hesaplandı");

    }

    public static int sum(int number1, int number2) {
        int total = number1 + number2;
        return total;
    }

    public static double tenPercentOfTheTwoNumbersAdded(int number1, int number2) {
        int total = sum(number1, number2);
        double result = total * 10 / 100;
        return result;
    }

    public static double calculateCredit(double creditQuantitiy) {
        return 125000;
    }
}
