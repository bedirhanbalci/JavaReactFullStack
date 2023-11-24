package com.tobeto.rent.a.car.demo.services.dtos.customer.responses;

import lombok.Data;

@Data
public class GetCustomerResponse {
    private String phone;
    private String email;
    private String address;
}
