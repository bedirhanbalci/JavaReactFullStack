package com.tobeto.rent.a.car.demo.services.dtos.corporate.requests;

import com.tobeto.rent.a.car.demo.entities.Customer;
import lombok.Data;

@Data
public class AddCorporateRequest {
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String taxNumber;
    private Customer customerId;
}
