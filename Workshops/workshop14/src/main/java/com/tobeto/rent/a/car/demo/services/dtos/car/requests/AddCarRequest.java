package com.tobeto.rent.a.car.demo.services.dtos.car.requests;

import com.tobeto.rent.a.car.demo.entities.Category;
import lombok.Data;

@Data
public class AddCarRequest {
    private String brand;
    private String model;
    private int year;
    private String color;
    private String status;
    private String numberPlate;
    private Category categoryId;
}