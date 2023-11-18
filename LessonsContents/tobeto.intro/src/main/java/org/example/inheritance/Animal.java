package org.example.inheritance;

// soyut bir class olursa new'lenemesin demek istiyorum. o yüzden main class da new'lenemiyor.
// aslında abstract cclass ile özel bir koşul belirlemiş oluyorum. bu benim ana class'ım buna dokunmayın diyorum. kısacası gidin sub class'larımla çalışın diyorum.
// benden miras alan class'larım benim abstract metodumu alabilmesi için bunu class'larında override etmesi gerekli.
// o yüzden bird ve dog'da animalSound() metodunu override ettik.

public abstract class Animal {
    // Animal class'ından türetiliyor ise o class bu methodu somut hale getirmek zorundadır.
    public abstract void animalSound();
    public void eat(){
        System.out.println("Animal is eating..");
    }

    public void  breathe(){
        System.out.println("Animal is breathing..");
    }
}
