package com.tobeto.rent.a.car.demo.services.dtos.option.responses;

import lombok.Data;

@Data
public class GetAllOptionsResponse {
    private int id;
    private double rentalCancellationPrice;
    private double additionalDriverPrice;
    private double roadsideAssistancePrice;
}