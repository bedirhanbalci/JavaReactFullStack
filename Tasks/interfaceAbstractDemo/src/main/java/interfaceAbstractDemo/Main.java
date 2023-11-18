package interfaceAbstractDemo;

import interfaceAbstractDemo.abstracts.BaseCustomerManager;
import interfaceAbstractDemo.adapters.MernisServiceAdapter;
import interfaceAbstractDemo.concrete.NeroCustomerManager;
import interfaceAbstractDemo.entities.Customer;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        BaseCustomerManager customerManager = new NeroCustomerManager(new MernisServiceAdapter());
        customerManager.save(new Customer(LocalDate.of(1999, 2, 24), "Bedirhan", "Balcı", "11111111111"));
        System.out.println();
    }
}