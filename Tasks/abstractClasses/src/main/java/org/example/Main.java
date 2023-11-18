package org.example;

public class Main {
    public static void main(String[] args) {

        WomanGameCalculator womanGameCalculator = new WomanGameCalculator();
        womanGameCalculator.calculate();
        womanGameCalculator.gameOver();

        GameCalculator gameCalculator = new WomanGameCalculator();

        // abstrack class'lar asla new'lenemezler. eğer onları kullanmak
        // istersen aşağıdaki gibi override etmek zorundasın!
        // bu kullanım pek hoş değil! önerilmez!
//        GameCalculator gameCalculator = new GameCalculator() {
//            @Override
//            public void calculate() {
//
//            }
//        };

    }
}