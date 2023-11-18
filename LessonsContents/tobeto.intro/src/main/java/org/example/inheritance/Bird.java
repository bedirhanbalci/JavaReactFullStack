package org.example.inheritance;

public class Bird extends Animal{
    public void fly(){
        System.out.println("Bird is flying..");
    }

    @Override
    public void animalSound() {
        System.out.println("Cik cik..");
    }

    @Override // annotation
    // override => superclass'daki bir metodu değiştirmek / yeniden yazmak
    public void breathe() {
        // super => extend edilen class'ı ifade eder.
        System.out.println("Kuş nefes alıyor");
        super.breathe();
    }
}
