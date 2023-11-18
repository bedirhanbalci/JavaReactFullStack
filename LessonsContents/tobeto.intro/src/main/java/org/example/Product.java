package org.example;

// erişim_belirteci class class_ismi
public class Product {


    // Access Modifier => Erişim Belirteci
    // public => tüm dış noktalardan erişime açık
    // private => sadece class içinden erişilebilir

    public Product() {
        System.out.println("Yeni bir ürün üretildi..");

    }

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, double unitPrice) {
        // this => class'ın kendisi
        this.name = name;
        this.unitPrice = unitPrice;
    }


    // Attribute'lar
    private String name;
    private double unitPrice;

    // getter-setter
    // okuma-yazma

    // sadece getter'i olan attrşbute'lar => read-only
    // sadece setter'i olan => write-only


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }


    // void => geriye değer dönmeyen metot türü
    public void applyDiscount(double priceToSubstract) {
        unitPrice = unitPrice - priceToSubstract;
        System.out.println(name + " ürününe " + priceToSubstract + " $ kadar indirim yapılmıştır.");
    }

    // Method Overloading => Aynı isim ama farklı imza ve scope'a sahip metotlar

}
