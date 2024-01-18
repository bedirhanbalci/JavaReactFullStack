package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Customer;
import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByPhone(String phone);

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse (c.id, c.phone, c.email, c.address)" +
            "FROM Customer c WHERE c.email LIKE '%.com'")
    List<GetListCustomerResponse> findByEmailLike();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse (c.id, c.phone, c.email, c.address)" +
            "FROM Customer c WHERE c.address IS NOT NULL")
    List<GetListCustomerResponse> findByAddressNotNull();

    boolean existsCustomerByPhone(String phone);

    boolean existsCustomerByEmail(String email);

}
