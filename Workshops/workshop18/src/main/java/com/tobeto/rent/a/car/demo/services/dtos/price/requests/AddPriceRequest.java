package com.tobeto.rent.a.car.demo.services.dtos.price.requests;

import com.tobeto.rent.a.car.demo.entities.Option;
import com.tobeto.rent.a.car.demo.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPriceRequest {
    private Option optionId;
    private Payment paymentId;
}