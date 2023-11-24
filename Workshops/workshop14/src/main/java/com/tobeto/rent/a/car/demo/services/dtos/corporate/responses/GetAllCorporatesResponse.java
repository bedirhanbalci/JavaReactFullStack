package com.tobeto.rent.a.car.demo.services.dtos.corporate.responses;

import com.tobeto.rent.a.car.demo.entities.Customer;
import lombok.Data;

@Data
public class GetAllCorporatesResponse {
    private int id;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private Customer customerId;
}