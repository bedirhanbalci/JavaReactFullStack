package com.tobeto.rent.a.car.demo.services.dtos.price.requests;

import com.tobeto.rent.a.car.demo.entities.Option;
import com.tobeto.rent.a.car.demo.entities.Payment;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePriceRequest {

    @Positive(message = "Doğru Fiyat id girişi yapınız!")
    private int id;

    private Option optionId;

    private Payment paymentId;
}
