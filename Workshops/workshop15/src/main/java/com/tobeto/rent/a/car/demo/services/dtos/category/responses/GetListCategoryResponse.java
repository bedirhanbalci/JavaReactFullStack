package com.tobeto.rent.a.car.demo.services.dtos.category.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCategoryResponse {
    private int id;
    private String name;
}
