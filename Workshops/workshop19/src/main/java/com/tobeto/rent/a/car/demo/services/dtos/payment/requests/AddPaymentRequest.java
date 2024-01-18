package com.tobeto.rent.a.car.demo.services.dtos.payment.requests;

import com.tobeto.rent.a.car.demo.entities.Customer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentRequest {

    @Min(value = 1, message = "Günlük kiralama fiyatı 1'den büyük olmalı")
    private double dailyPrice;

    @Min(value = 1, message = "Haftalık kiralama fiyatı 1'den büyük olmalı")
    private double weeklyPrice;

    @Min(value = 1, message = "Aylık kiralama fiyatı 1'den büyük olmalı")
    private double monthlyPrice;

    @Min(value = 1, message = "Sigorta fiyatı 1'den büyük olmalı")
    private double assurancePrice;

    @Min(value = 1, message = "Benzin fiyatı 1'den büyük olmalı")
    private double fuelPrice;

    private Customer customerId;
}