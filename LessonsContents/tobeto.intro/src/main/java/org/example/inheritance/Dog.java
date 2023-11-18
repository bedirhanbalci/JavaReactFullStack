package org.example.inheritance;

public class Dog extends Animal{

    @Override
    public void animalSound() {
        System.out.println("Hav hav..");

    }

    public void walk(){
        System.out.println("Dog is walking..");
    }
}
