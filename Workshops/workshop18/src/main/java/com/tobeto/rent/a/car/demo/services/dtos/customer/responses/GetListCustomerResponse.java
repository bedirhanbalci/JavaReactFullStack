package com.tobeto.rent.a.car.demo.services.dtos.customer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCustomerResponse {
    private int id;
    private String phone;
    private String email;
    private String address;

}
