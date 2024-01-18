package com.tobeto.rent.a.car.demo.services.dtos.payment.responses;

import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListPaymentResponse {
    private int id;
    private double dailyPrice;
    private double weeklyPrice;
    private double monthlyPrice;
    private GetListCustomerResponse customer;

}
