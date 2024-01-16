package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Customer;
import com.tobeto.rent.a.car.demo.repositories.CustomerRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.CustomerService;
import com.tobeto.rent.a.car.demo.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rent.a.car.demo.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetAllCustomersResponse;
import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetCustomerResponse;
import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void add(AddCustomerRequest addCustomerRequest) {

        if (customerRepository.existsCustomerByPhone(addCustomerRequest.getPhone())) {
            throw new RuntimeException("Aynı telefon numarası eklenemez!");
        }

        if (customerRepository.existsCustomerByEmail(addCustomerRequest.getEmail())) {
            throw new RuntimeException("Aynı email eklenemez!");
        }


        Customer customer = new Customer();
        customer.setPhone(addCustomerRequest.getPhone());
        customer.setEmail(addCustomerRequest.getEmail());
        customer.setAddress(addCustomerRequest.getAddress());
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);
    }

    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {

        if (customerRepository.existsCustomerByPhone(updateCustomerRequest.getPhone())) {
            throw new RuntimeException("Aynı telefon numarası eklenemez! Lütfen tekrar deneyiniz.");
        }

        if (customerRepository.existsCustomerByEmail(updateCustomerRequest.getEmail())) {
            throw new RuntimeException("Aynı email eklenemez! Lütfen tekrar deneyiniz.");
        }

        Customer customerToUpdate = customerRepository.findById(updateCustomerRequest.getId()).orElseThrow();
        customerToUpdate.setPhone(updateCustomerRequest.getPhone());
        customerToUpdate.setEmail(updateCustomerRequest.getEmail());
        customerToUpdate.setAddress(updateCustomerRequest.getAddress());
        customerRepository.save(customerToUpdate);
    }

    @Override
    public GetCustomerResponse getById(int id) {
        Customer customerToId = customerRepository.findById(id).orElseThrow();
        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();
        getCustomerResponse.setPhone(customerToId.getPhone());
        getCustomerResponse.setEmail(customerToId.getEmail());
        getCustomerResponse.setAddress(customerToId.getAddress());
        return getCustomerResponse;
    }

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customerList = customerRepository.findAll();
        List<GetAllCustomersResponse> getAllCustomersResponseList = new ArrayList<>();
        for (Customer customer : customerList) {
            GetAllCustomersResponse getAllCustomersResponse = new GetAllCustomersResponse();
            getAllCustomersResponse.setId(customer.getId());
            getAllCustomersResponse.setPhone(customer.getPhone());
            getAllCustomersResponse.setEmail(customer.getEmail());
            getAllCustomersResponse.setAddress(customer.getAddress());
            getAllCustomersResponseList.add(getAllCustomersResponse);
        }
        return getAllCustomersResponseList;
    }

    @Override
    public List<Customer> getByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public List<GetListCustomerResponse> getByEmailLike() {
//        return customerRepository.findByEmailLike();

        return customerRepository.findByEmailLike().stream().map((customer) -> {
            return new GetListCustomerResponse(customer.getId(), customer.getPhone(), customer.getEmail(), customer.getAddress());
        }).toList();
    }

    @Override
    public List<GetListCustomerResponse> getByAddressNotNull() {
//        return customerRepository.findByAddressNotNull();
        return customerRepository.findByAddressNotNull().stream().map((customer) -> {
            return new GetListCustomerResponse(customer.getId(), customer.getPhone(), customer.getEmail(), customer.getAddress());
        }).toList();
    }
}