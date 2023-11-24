package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.category.requests.AddCategoryRequest;
import com.tobeto.rent.a.car.demo.services.dtos.category.requests.UpdateCategoryRequest;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetAllCategoriesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetCategoryResponse;

import java.util.List;

public interface CategoryService {

    void add(AddCategoryRequest addCategoryRequest);

    void delete(int id);

    void update(UpdateCategoryRequest updateCategoryRequest);

    GetCategoryResponse getById(int id);

    List<GetAllCategoriesResponse> getAll();
}
