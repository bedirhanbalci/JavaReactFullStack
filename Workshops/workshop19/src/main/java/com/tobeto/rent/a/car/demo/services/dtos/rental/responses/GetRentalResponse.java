package com.tobeto.rent.a.car.demo.services.dtos.rental.responses;

import com.tobeto.rent.a.car.demo.entities.*;
import lombok.Data;

@Data
public class GetRentalResponse {
    private Payment paymentId;
    private Customer customerId;
    private Car carId;
    private Date dateId;
    private Location locationId;
}
