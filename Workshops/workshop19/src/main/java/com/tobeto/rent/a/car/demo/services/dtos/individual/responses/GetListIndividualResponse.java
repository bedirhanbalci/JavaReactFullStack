package com.tobeto.rent.a.car.demo.services.dtos.individual.responses;

import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListIndividualResponse {
    private int id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;
    private GetListCustomerResponse customer;
}
