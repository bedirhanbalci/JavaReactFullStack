package uniqueChar_5;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // string'in uzunluğunu al
        // String'i hashset'e ekle
        // hashset'in uzunluğunu yazdır
        // string'in uzunluğuyla hashset'in uzunluğunu eşitle

        String text = "aysenur";
        HashSet<String> str = new HashSet<>();

        for (int i = 0; i < text.length(); i++) {
            str.add(text.substring(i, i + 1));
        }
        if (text.length() == str.size()) {
            System.out.println("Unique");
        } else {
            System.out.println("Not Unique!");
        }
    }
}
