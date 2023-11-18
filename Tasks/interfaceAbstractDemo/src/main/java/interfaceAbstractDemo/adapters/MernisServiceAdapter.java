package interfaceAbstractDemo.adapters;

import interfaceAbstractDemo.abstracts.ICustomerCheckService;
import interfaceAbstractDemo.entities.Customer;

public class MernisServiceAdapter implements ICustomerCheckService {

    @Override
    public boolean checkIfRealPerson(Customer customer) {
        return true;
    }
}
