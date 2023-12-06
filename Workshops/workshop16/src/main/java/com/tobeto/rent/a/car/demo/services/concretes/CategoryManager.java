package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Category;
import com.tobeto.rent.a.car.demo.repositories.CategoryRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.CategoryService;
import com.tobeto.rent.a.car.demo.services.dtos.category.requests.AddCategoryRequest;
import com.tobeto.rent.a.car.demo.services.dtos.category.requests.UpdateCategoryRequest;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetAllCategoriesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetCategoryResponse;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Manager
@AllArgsConstructor
@Service
public class CategoryManager implements CategoryService {

    private final CategoryRepository categoryRepository;

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

    @Override
    public List<Category> getByName(String name) {
        return categoryRepository.findByNameStartingWith(name);
    }

    @Override
    public List<GetListCategoryResponse> getByNameDto(String name) {

        // TODO: Yaklaşım 1: Repository'den List<Category>'yi alıp Service katmanında Map'leyerek DTO türüne çevirmek.

/*        List<Category> categories = categoryRepository.findByNameStartingWith(name);
        List<GetListCategoryResponse> getListCategoryResponses = new ArrayList<>();

        for (Category category : categories) {
            getListCategoryResponses.add(new GetListCategoryResponse(category.getName()));
        }
*/


        return categoryRepository.findByNameStartingWith(name).stream().map((category) -> {
            return new GetListCategoryResponse(category.getId(), category.getName());
        }).toList();


        // TODO: Yaklaşım 2: Repository'de List<GetListCategoryResponse> dönebilen yeni bir metot oluşturmak. (Stream api'ler ile)
        //return categoryRepository.findByName(name);


    }
}

// Lambda Expression & Steam API