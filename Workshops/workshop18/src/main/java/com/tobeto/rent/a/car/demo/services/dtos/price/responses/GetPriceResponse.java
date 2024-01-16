package com.tobeto.rent.a.car.demo.services.dtos.price.responses;

import com.tobeto.rent.a.car.demo.entities.Option;
import com.tobeto.rent.a.car.demo.entities.Payment;
import lombok.Data;

@Data
public class GetPriceResponse {
    private Option optionId;
    private Payment paymentId;
}