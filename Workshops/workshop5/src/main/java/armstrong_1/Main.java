package armstrong_1;

public class Main {
    public static void main(String[] args) {
        int number = 153;

        String numberString = String.valueOf(number);

        int basamakSayisi = numberString.length();

        int result = 0;
        int total = 1;

        for (int i = 0; i < basamakSayisi; i++) {
            for (int j = 0; j < basamakSayisi; j++) {
                int temp = Integer.parseInt(numberString.substring(i, i + 1));
                total = total * temp;
            }
            result += total;
            total = 1;
        }
        if (number == result) {
            System.out.println("Armstrong");
        } else {
            System.out.println("Armstrong değil!");
        }
    }
}


