package intro;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String middleText = "İlginizi çekebilir";
        String subText = "Vade süresi";

        System.out.println(middleText);

        int maturity = 12;
        double dollarYesterday = 18.25;
        double dollarToday = 18.30;
        boolean isDollarDown = false;

        String arrowDirection = "";

        if (dollarToday < dollarYesterday) { // false
            arrowDirection = "down.svg";
            System.out.println(arrowDirection);
        } else if (dollarToday > dollarYesterday) {
            arrowDirection = "up.svg";
            System.out.println(arrowDirection);
        } else {
            arrowDirection = "equal.svg";
            System.out.println(arrowDirection);
        }


        String[] credits = {"Hızlı Kredi", "Maaşını Halkbanktan", "Mutlu Emekli"};

        for (int i = 0; i < credits.length; i++) {
            System.out.println(credits[i]);
        }
    }
}
