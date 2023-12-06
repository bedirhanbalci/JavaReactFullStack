package com.tobeto.rent.a.car.demo.services.dtos.payment.requests;

import com.tobeto.rent.a.car.demo.entities.Customer;
import lombok.Data;

@Data
public class UpdatePaymentRequest {
    private int id;
    private double dailyPrice;
    private double weeklyPrice;
    private double monthlyPrice;
    private Customer customerId;
}