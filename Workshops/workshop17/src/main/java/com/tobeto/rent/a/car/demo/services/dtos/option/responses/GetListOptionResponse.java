package com.tobeto.rent.a.car.demo.services.dtos.option.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListOptionResponse {
    private int id;
    private double rentalCancellationPrice;
    private double additionalDriverPrice;
    private double roadsideAssistancePrice;

}
