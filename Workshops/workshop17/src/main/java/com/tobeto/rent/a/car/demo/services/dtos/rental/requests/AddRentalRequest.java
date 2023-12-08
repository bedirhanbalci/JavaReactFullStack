package com.tobeto.rent.a.car.demo.services.dtos.rental.requests;

import com.tobeto.rent.a.car.demo.entities.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {
    private Payment paymentId;
    private Customer customerId;
    private Car carId;
    private Date dateId;
    private Location locationId;

    @NotBlank(message = "Rezervasyon boş olamaz!")
    private String reservation;
}