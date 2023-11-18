package perfectNumber_7;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int n = 2;
        BigInteger[] perfectNumbers = new BigInteger[10];

        while (count < 10) {
            BigInteger number = BigInteger.valueOf(2).pow(n - 1);
            BigInteger isPrime = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);

            if (isPrime.isProbablePrime(10)) { // Asal sayı kontrolü için isProbablePrime kullanılır
                BigInteger perfectNumber = number.multiply(isPrime);// number*isPrime
                perfectNumbers[count] = perfectNumber;
                count++;
            }
            n++;
        }

        for (BigInteger number : perfectNumbers) {
            System.out.println(number);
        }
    }
}
