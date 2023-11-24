package com.tobeto.rent.a.car.demo.services.dtos.price.requests;

import com.tobeto.rent.a.car.demo.entities.Option;
import com.tobeto.rent.a.car.demo.entities.Payment;
import lombok.Data;

@Data
public class UpdatePriceRequest {
    private int id;
    private Option optionId;
    private Payment paymentId;
}
