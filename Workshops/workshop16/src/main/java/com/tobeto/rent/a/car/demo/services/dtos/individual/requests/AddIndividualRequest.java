package com.tobeto.rent.a.car.demo.services.dtos.individual.requests;

import com.tobeto.rent.a.car.demo.entities.Customer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddIndividualRequest {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;
    private String identificationNumber;
    private Customer customerId;
}
