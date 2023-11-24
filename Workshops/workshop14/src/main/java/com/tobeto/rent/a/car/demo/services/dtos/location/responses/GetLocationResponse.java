package com.tobeto.rent.a.car.demo.services.dtos.location.responses;

import lombok.Data;

@Data
public class GetLocationResponse {
    private String pickUpLocation;
    private String dropOffLocation;
}