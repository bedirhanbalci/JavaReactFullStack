package com.tobeto.rent.a.car.demo.services.dtos.payment.responses;

import com.tobeto.rent.a.car.demo.entities.Customer;
import lombok.Data;

@Data
public class GetPaymentResponse {
    private double dailyPrice;
    private double weeklyPrice;
    private double monthlyPrice;
    private Customer customerId;
}