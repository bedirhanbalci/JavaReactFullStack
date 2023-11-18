package interfaceAbstractDemo.concrete;

import interfaceAbstractDemo.abstracts.ICustomerCheckService;

import interfaceAbstractDemo.entities.Customer;

public class CustomerCheckManager implements ICustomerCheckService {

    @Override
    public boolean checkIfRealPerson(Customer customer) {
        return true;
    }
}
