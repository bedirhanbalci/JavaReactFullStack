package com.tobeto.rent.a.car.demo.services.dtos.option.responses;

import lombok.Data;

@Data
public class GetOptionResponse {
    private double rentalCancellationPrice;
    private double additionalDriverPrice;
    private double roadsideAssistancePrice;
}