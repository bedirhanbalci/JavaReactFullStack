package com.tobeto.rent.a.car.demo.services.dtos.option.requests;

import lombok.Data;

@Data
public class UpdateOptionRequest {
    private int id;
    private double rentalCancellationPrice;
    private double additionalDriverPrice;
    private double roadsideAssistancePrice;
}
