package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Customer;
import com.tobeto.rent.a.car.demo.services.abstracts.CustomerService;
import com.tobeto.rent.a.car.demo.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rent.a.car.demo.services.dtos.customer.requests.UpdateCustomerRequest;
import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetAllCustomersResponse;
import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetCustomerResponse;
import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomersController {

    private final CustomerService customerService;

    @PostMapping
    public void add(@RequestBody @Valid AddCustomerRequest addCustomerRequest) {
        customerService.add(addCustomerRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        customerService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {
        customerService.update(updateCustomerRequest);
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable int id) {
        return customerService.getById(id);
    }

    @GetMapping("all")
    public List<GetAllCustomersResponse> getAll() {
        return customerService.getAll();
    }

    @GetMapping("phone")
    public List<Customer> getByPhone(@RequestParam String phone) {
        return customerService.getByPhone(phone);
    }

    @GetMapping("emailLike")
    public List<GetListCustomerResponse> getByEmailLike() {
        return customerService.getByEmailLike();
    }

    @GetMapping("addressNotNull")
    public List<GetListCustomerResponse> getByAddressNotNull() {
        return customerService.getByAddressNotNull();
    }
}