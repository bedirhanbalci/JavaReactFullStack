package com.tobeto.rent.a.car.demo.services.dtos.price.responses;

import com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetListOptionResponse;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetListPaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListPriceResponse {
    private int id;
    private GetListOptionResponse option;
    private GetListPaymentResponse payment;
}
