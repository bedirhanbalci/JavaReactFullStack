package charCount_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> list = new HashMap<>();
        String str = "malatya";

        for (int i = 0; i < str.length(); i++) {
            String temp;
            temp = (str.substring(i, i + 1));
            Integer temp2 = list.get(temp);

            if (temp2 != null) {
                list.put(temp, temp2 + 1);
            } else {

                list.put(temp, 1);
            }

        }
        for (String step : list.keySet()) {
            System.out.print(step + " -- ");
            System.out.println(list.get(step));
        }
    }
}
