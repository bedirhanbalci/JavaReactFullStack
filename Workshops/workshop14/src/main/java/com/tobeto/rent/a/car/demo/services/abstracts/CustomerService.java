package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rent.a.car.demo.services.dtos.customer.requests.UpdateCustomerRequest;

public interface CustomerService {

    void add(AddCustomerRequest addCustomerRequest);

    void delete(int id);

    void update(UpdateCustomerRequest updateCustomerRequest);
}
