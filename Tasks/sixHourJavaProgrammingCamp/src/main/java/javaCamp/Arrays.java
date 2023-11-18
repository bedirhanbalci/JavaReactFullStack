package javaCamp;

import java.util.ArrayList;

public class Arrays {
    public static void main(String[] args) {


//        ArrayList<String> cities = new ArrayList<String>();
//        cities.add("Ankara");
//        cities.add("İstanbul");
//        cities.add("İzmir");
//
//        for (String city : cities) {
//            System.out.println(city);
//        }


        String[] cities = new String[]{"Ankara", "İstanbul", "İzmir"};

        for (String city : cities) {
            System.out.println(city);
        }

        System.out.println("--------");

        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }

        System.out.println("--------");

        String[] cities1 = new String[]{"Ankara", "İstanbul", "İzmir"};

        String[] cities2 = new String[]{"Gaziantep", "Diyarbakır", "Şanlıurfa"};

        cities1 = cities2;
        cities1[0] = "Adana";
        System.out.println(cities2[0]);

        int number1 = 10;
        int number2 = 20;
        number1 = number2;
        number2 = 30;
        System.out.println(number1);
    }
}
