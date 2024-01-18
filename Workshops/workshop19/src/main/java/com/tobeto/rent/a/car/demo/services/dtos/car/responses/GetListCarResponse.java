package com.tobeto.rent.a.car.demo.services.dtos.car.responses;

import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCarResponse {
    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private String status;
    private GetListCategoryResponse category;
}
