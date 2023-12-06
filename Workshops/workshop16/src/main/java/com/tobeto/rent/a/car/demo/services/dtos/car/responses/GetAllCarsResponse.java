package com.tobeto.rent.a.car.demo.services.dtos.car.responses;

import com.tobeto.rent.a.car.demo.entities.Category;
import lombok.Data;

@Data
public class GetAllCarsResponse {
    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private String status;
    private Category categoryId;
}