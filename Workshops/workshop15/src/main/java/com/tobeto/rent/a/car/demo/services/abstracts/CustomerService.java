package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.entities.Customer;
import com.tobeto.rent.a.car.demo.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rent.a.car.demo.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetAllCustomersResponse;
import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetCustomerResponse;
import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {

    void add(AddCustomerRequest addCustomerRequest);

    void delete(int id);

    void update(UpdateCustomerRequest updateCustomerRequest);

    GetCustomerResponse getById(int id);

    List<GetAllCustomersResponse> getAll();

    List<Customer> getByPhone(String phone);

    List<GetListCustomerResponse> getByEmailLike();

    List<GetListCustomerResponse> getByAddressNotNull();
}
