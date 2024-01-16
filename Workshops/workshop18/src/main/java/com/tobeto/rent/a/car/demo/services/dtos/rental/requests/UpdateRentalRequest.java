package com.tobeto.rent.a.car.demo.services.dtos.rental.requests;

import com.tobeto.rent.a.car.demo.entities.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    @Positive(message = "Kiralama id bilgisini doğru giriniz!")
    private int id;

    private Payment paymentId;
    private Customer customerId;
    private Car carId;
    private Date dateId;
    private Location locationId;
}