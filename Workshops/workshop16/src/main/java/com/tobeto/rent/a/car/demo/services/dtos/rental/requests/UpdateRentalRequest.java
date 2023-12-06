package com.tobeto.rent.a.car.demo.services.dtos.rental.requests;

import com.tobeto.rent.a.car.demo.entities.*;
import lombok.Data;

@Data
public class UpdateRentalRequest {
    private int id;
    private Payment paymentId;
    private Customer customerId;
    private Car carId;
    private Date dateId;
    private Location locationId;
}