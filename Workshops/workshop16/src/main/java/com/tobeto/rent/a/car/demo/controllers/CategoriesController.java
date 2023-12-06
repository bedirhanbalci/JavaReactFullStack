package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Category;
import com.tobeto.rent.a.car.demo.services.abstracts.CategoryService;
import com.tobeto.rent.a.car.demo.services.dtos.category.requests.AddCategoryRequest;
import com.tobeto.rent.a.car.demo.services.dtos.category.requests.UpdateCategoryRequest;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetAllCategoriesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetCategoryResponse;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Single Responsibility

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoriesController {
    // Gelen isteği kontrol etmek ve yönlendirmek
    // manager bağımlılığını yüklemek
    // Bağımlılıklar daima soyut nesneler üzerinden

    private final CategoryService categoryService;

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

    @GetMapping("all")
    public List<GetAllCategoriesResponse> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("name")
    public List<Category> getByName(@RequestParam String name) {
        return categoryService.getByName(name);
    }

    @GetMapping("dto")
    public List<GetListCategoryResponse> getByNameDto(@RequestParam String name) {
        return categoryService.getByNameDto(name);
    }
}