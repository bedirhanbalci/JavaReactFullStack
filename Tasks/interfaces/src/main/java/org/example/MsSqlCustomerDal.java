package org.example;

public class MsSqlCustomerDal implements ICustomerDal {
    @Override
    public void add() {
        System.out.println("Ms sql eklendi");
    }
}
