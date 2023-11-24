package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Category;
import com.tobeto.rent.a.car.demo.repositories.CategoryRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.CategoryService;
import com.tobeto.rent.a.car.demo.services.dtos.category.requests.AddCategoryRequest;
import com.tobeto.rent.a.car.demo.services.dtos.category.requests.UpdateCategoryRequest;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetAllCategoriesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetCategoryResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Manager
@Service
public class CategoryManager implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryManager(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(AddCategoryRequest addCategoryRequest) {
        Category category = new Category();
        category.setName(addCategoryRequest.getName());
        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        Category categoryToDelete = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(categoryToDelete);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        Category categoryToUpdate = categoryRepository.findById(updateCategoryRequest.getId()).orElseThrow();
        categoryToUpdate.setName(updateCategoryRequest.getName());
        categoryRepository.save(categoryToUpdate);
    }

    @Override
    public GetCategoryResponse getById(int id) {
        Category categoryToId = categoryRepository.findById(id).orElseThrow();
        GetCategoryResponse getCategoryResponse = new GetCategoryResponse();
        getCategoryResponse.setName(categoryToId.getName());
        return getCategoryResponse;
    }

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categoryList = categoryRepository.findAll();
        List<GetAllCategoriesResponse> getAllCategoriesResponseList = new ArrayList<>();
        for (Category category : categoryList) {
            GetAllCategoriesResponse getAllCategoriesResponse = new GetAllCategoriesResponse();
            getAllCategoriesResponse.setId(category.getId());
            getAllCategoriesResponse.setName(category.getName());
            getAllCategoriesResponseList.add(getAllCategoriesResponse);
        }
        return getAllCategoriesResponseList;
    }
}