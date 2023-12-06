package com.tobeto.rent.a.car.demo.services.dtos.location.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListLocationResponse {
    private int id;
    private String pickUpLocation;
    private String dropOffLocation;
}
