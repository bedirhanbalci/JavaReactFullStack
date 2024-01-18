package com.tobeto.rent.a.car.demo.services.dtos.option.requests;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOptionRequest {

    @Min(value = 1, message = "Kiralama iptal fiyatı 1'den büyük olmalı")
    private double rentalCancellationPrice;

    @Min(value = 1, message = "Ek sürücü fiyatı 1'den büyük olmalı")
    private double additionalDriverPrice;

    @Min(value = 1, message = "Yol yardım fiyatı 1'den büyük olmalı")
    private double roadsideAssistancePrice;
}
