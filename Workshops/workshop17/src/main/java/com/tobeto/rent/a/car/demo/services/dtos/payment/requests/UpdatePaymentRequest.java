package com.tobeto.rent.a.car.demo.services.dtos.payment.requests;

import com.tobeto.rent.a.car.demo.entities.Customer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {

    @Positive(message = "Ödeme id'yi doğru giriniz!")
    private int id;

    @Min(value = 1, message = "Günlük kiralama fiyatı 1'den büyük olmalı")
    private double dailyPrice;

    @Min(value = 1, message = "Haftalık kiralama fiyatı 1'den büyük olmalı")
    private double weeklyPrice;

    @Min(value = 1, message = "Aylık kiralama fiyatı 1'den büyük olmalı")
    private double monthlyPrice;

    private Customer customerId;
}