package org.example;


// Built-in Packages

import java.util.Arrays;

// User Defined Packages
// Paketten sadece example'ı import eder
//import org.example.models.Example;


// All
// Paketteki tüm tanımlamaları import eder.
import org.example.inheritance.Animal;
import org.example.inheritance.Bird;
import org.example.inheritance.Dog;
import org.example.models.*;


// Dependencies => Projenin bağımlılıkları
import lombok.*;


public class Main {
    public static void main(String[] args) {

        // ----------------------------- 1.Gun -----------------------------------

        System.out.println("Hello World!");

        String name = "Bedirhan";

        Integer age = 24;

        int days = 50;

        var age_2 = 24;

        System.out.println(name);

        // Mantıksal operatörler
        // == != > < >= <=
        boolean isLoggedIn = false;
        boolean value2 = true;
        boolean value3 = true;
        System.out.println(isLoggedIn);

        // programın belli bir şartı yerine getirdiğinde
        // execute etmesini istediğim kodlar..
        // Bir if bloğundan bir karar çıkar

        if (isLoggedIn) { // True ise
            System.out.println("Giriş yapılmış..");
        } else if (value2) {
            System.out.println("2. if bloğu");
        }
        if (1 == 1 && value2) {
            System.out.println("3. if bloğu");
        } else {
            System.out.println("Giriş yapılmamış..");
        }

        // Scope

        String text = "Deneme";

        if (true) {
            String text1 = "Deneme";
            if (false) {
                System.out.println(text);
                System.out.println(text1);
                String text2 = "Merhaba";
            }
            System.out.println(text);
        }

        int age2 = 17;
        Boolean canRegister;


        if (age2 < 18) {
            canRegister = false;
        } else {
            canRegister = true;
        }

        if (canRegister) {
            System.out.println("Kayıt olabilir!");
        } else {
            System.out.println("Kayıt olamaz.");
        }


        // ----------------------------- 2.Gun -----------------------------------


        // Stack, Heap

        // Primitive Type => boolean, integer, long, byte => Stack
        // a =>, b => true

        // Reference Type => class, interface, Array
        // Stack complex objeleri barındırıyor


        String[] nameArray = {"Bedirhan", "Emirhan", "Halit", "Halil"};
        // nameArray @abc
        //System.out.println(nameArray);

        String[] array2 = nameArray;
        // array2 @abc
        //System.out.println(array2);

        // @abc[0] = "Enes"
        array2[0] = "Enes";

        // iterasyon => tekrar
        for (int i = 0; i < nameArray.length; i++) {
            System.out.println(nameArray[i]);
        }


        String[] array3 = Arrays.copyOf(nameArray, nameArray.length);
        System.out.println(nameArray);
        System.out.println(array3);

        array3[0] = "Vedat";

        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }

        System.out.println("***********");

        for (int i = 0; i < nameArray.length; i++) {
            System.out.println(nameArray[i]);
        }


        Integer[] numbers = {1, 2, 3, 4};
        //System.out.println(numbers);

        Integer[] copyNumbers = Arrays.copyOf(numbers, numbers.length);
        //System.out.println(copyNumbers);

        for (Integer number : numbers) {
            System.out.println(number);
        }


        // OOP

        // n adet instance => örnek
        Product instance1 = new Product();
        instance1.setName("Laptop");
        instance1.setUnitPrice(5000);
        instance1.applyDiscount(10);

        // instance
        Product instance2 = new Product();
        instance2.setName("Mouse");
        instance2.setUnitPrice(200);


        System.out.println("Ürün Adı : " + instance1.getName() + " Ürün Fiyatı : " + instance1.getUnitPrice());


        // construct
        // construct => yapıcı metot
        Product product = new Product();
        Product product1 = new Product("Deneme");
        Product product2 = new Product("Deneme2", 500);
        System.out.println(product2.getName());
        System.out.println(product2.getUnitPrice());


        // ----------------------------- 3.Gun -----------------------------------

        // Packages
        // Import etmeden kullanılamaz. Çünkü farklı pakette.
        Example example = new Example();
        Sample sample = new Sample();


        // Inheritance => Kalıtım, Miras

        // SuperClass
        //Animal animal = new Animal();

        // Subclasses
        Bird bird = new Bird();
        Dog dog = new Dog();

        //animal.breathe();
        bird.breathe();
        bird.animalSound();

        dog.breathe();
        dog.animalSound();


        // polymorphism
        // aynı türden başka tür gibiymiş çalışmasını istediğimiz zaman kullanırız. birden fazla çeşitte bulunabilmek demek.
        // yani animal class'ı burada hem dog hem de bird halinde bulunabiliyor..
        Animal animal = new Bird();
        Animal animal2 = new Dog();


        flyExternal(animal);
        flyExternal(animal2);
    }

        public static void flyExternal(Animal animal){
            if(animal instanceof Bird){ // Animal bir bird türü mü
                Bird bird = (Bird)animal;
                bird.fly();
            }
            if(animal instanceof Dog){
                Dog dog = (Dog) animal;
                dog.walk();
            }

    }
}