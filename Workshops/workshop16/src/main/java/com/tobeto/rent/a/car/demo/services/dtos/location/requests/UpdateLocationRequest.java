package com.tobeto.rent.a.car.demo.services.dtos.location.requests;

import lombok.Data;

@Data
public class UpdateLocationRequest {
    private int id;
    private String pickUpLocation;
    private String dropOffLocation;
}
