package org.example.interfaces;

public interface Animal {
    // interface'lerde metotların başında default diye belirtmediğiniz sürece hiçbir metodun body'si olamaz ({})
    // burada sadece metot imza tutuyoruz
    // zorunlu bir şekilde belirtilmelidir. interface'imi kullanan classlar benim metotlarımı zorunlu şekilde belirtmelidir. ve birden çok class'ı implement edebilir.
    // o yüzden class yapılarına göre daha kullanışlıdır.
    void animalSound();

    void breathe();

    void dog();
}
