package com.tobeto.rent.a.car.demo.services.dtos.rental.responses;

import com.tobeto.rent.a.car.demo.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentalResponse {
    private int id;
    private Payment paymentId;
    private Customer customerId;
    private Car carId;
    private Date dateId;
    private Location locationId;
    private String reservation;
}
