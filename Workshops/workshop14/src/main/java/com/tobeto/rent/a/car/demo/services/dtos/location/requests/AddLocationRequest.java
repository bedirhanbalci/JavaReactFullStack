package com.tobeto.rent.a.car.demo.services.dtos.location.requests;

import lombok.Data;

@Data
public class AddLocationRequest {
    private String pickUpLocation;
    private String dropOffLocation;
}
