package javaCamp;

public class Workshop1 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 5, 7, 9, 0};
        int search = 2;

        boolean isHas = findNumber(numbers, search);

        showMessage(isHas, search);

    }

    public static void showMessage(boolean isHas, int search) {
        String message = "";
        if (isHas == true) {
            message = ("Sayı mevcuttur: " + search);
            System.out.println(message);
        } else {
            message = ("Sayı mevcut değildir: " + search);
            System.out.println(message);
        }
    }

    public static boolean findNumber(int[] numbers, int search) {
        boolean isHas = false;

        for (int number : numbers) {
            if (number == search) {
                isHas = true;
                break;
            }
        }
        return isHas;
    }
}
