package org.example;

public class BaseCreditManager {

    // public'den sonra "final" keyword'ünü kullanarak herhangi bir metodun override olma özelliğini kapatmış oluruz
    // yani derim ki sen benim metodumu hiçbir yerde kullanamazsın! Değişiklik yapamazsın!
    public double calculate(double price) {
        return price * 1.18;
    }
}
