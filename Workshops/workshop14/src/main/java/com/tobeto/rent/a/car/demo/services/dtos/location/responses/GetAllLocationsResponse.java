package com.tobeto.rent.a.car.demo.services.dtos.location.responses;

import lombok.Data;

@Data
public class GetAllLocationsResponse {
    private int id;
    private String pickUpLocation;
    private String dropOffLocation;
}