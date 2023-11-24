package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.CategoryService;
import com.tobeto.rent.a.car.demo.services.dtos.category.requests.AddCategoryRequest;
import com.tobeto.rent.a.car.demo.services.dtos.category.requests.UpdateCategoryRequest;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetAllCategoriesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetCategoryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Single Responsibility

@RestController
@RequestMapping("api/categories")
public class CategoriesController {
    // Gelen isteği kontrol etmek ve yönlendirmek
    // manager bağımlılığını yüklemek
    // Bağımlılıklar daima soyut nesneler üzerinden

    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void add(@RequestBody AddCategoryRequest addCategoryRequest) {
        categoryService.add(addCategoryRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
        categoryService.update(updateCategoryRequest);
    }

    @GetMapping("{id}")
    public GetCategoryResponse getById(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @GetMapping
    public List<GetAllCategoriesResponse> getAll() {
        return categoryService.getAll();
    }
}