package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.category.requests.AddCategoryRequest;
import com.tobeto.rent.a.car.demo.services.dtos.category.requests.UpdateCategoryRequest;

public interface CategoryService {

    void add(AddCategoryRequest addCategoryRequest);

    void delete(int id);

    void update(UpdateCategoryRequest updateCategoryRequest);
}
