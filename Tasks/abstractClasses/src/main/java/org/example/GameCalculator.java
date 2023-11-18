package org.example;

public abstract class GameCalculator {
    // abstract class mantık: ben base metodumda bunu hesaplamak istemiyorum o yüzden diyorum ki:
    // kim GameCalculator abstract class'ını inherit ediyorsa calculate() metodunu override etmek zorunda!
    // yani kendi calculate()'ini yazmak zorunda!
    public abstract void calculate();

    // final mantık: kim GameCalculator'ı kullanıyorsa gameOver() metodunu olduğu gibi kullanmak zorunda
    // override edilemez!
    public final void gameOver() {
        System.out.println("Oyun bitti");
    }
}
