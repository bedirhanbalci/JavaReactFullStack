package anagram_4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //asya-yasa, asgari-sigara


        String str1 = "asya";
        String str2 = "yasa";
        String str3 = "";
        String str4 = "";
        char[] chr1 = str1.toCharArray();
        char[] chr2 = str2.toCharArray();
        Arrays.sort(chr1);
        Arrays.sort(chr2);



        for (char chars : chr1) {
            str3 += chars;
        }
        for (char chars : chr2) {
            str4 += chars;
        }

        if (str3.equals(str4)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Anagram değil!");
        }

//        System.out.println(str3.equals(str4));


    }
}

