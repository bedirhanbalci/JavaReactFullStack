package interfaceAbstractDemo.concrete;

import interfaceAbstractDemo.abstracts.BaseCustomerManager;
import interfaceAbstractDemo.abstracts.ICustomerCheckService;
import interfaceAbstractDemo.entities.Customer;

public class NeroCustomerManager extends BaseCustomerManager {

    private ICustomerCheckService customerCheckService;

    public NeroCustomerManager(ICustomerCheckService customerCheckService) {
        this.customerCheckService = customerCheckService;
    }

    @Override
    public void save(Customer customer) throws Exception {
        if (customerCheckService.checkIfRealPerson(customer)) {
            save(customer);
        } else {
            throw new Exception("Not a valid person");
        }
    }
}
