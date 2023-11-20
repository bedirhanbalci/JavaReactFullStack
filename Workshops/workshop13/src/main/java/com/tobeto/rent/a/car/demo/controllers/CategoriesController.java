package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Category;
import com.tobeto.rent.a.car.demo.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {


    // final => sadece constructor'da ilgili değerin atamasının yapılabileceğini söyler

    private final CategoryRepository categoryRepository;

    public CategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    // Dependency Intection


    // Spring IoC => Dependency Injection Container Araştır!

    @GetMapping
    public List<Category> getAll() {
        // findAll => hazir bir JPArepositry fonksiyonu. tüm verileri bize döner
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable int id) {
        // Optional => opsiyonel olarak Category yani null olma ihtimali de var
        // verilen id ile bir veri varsa onu dön, yoksa exception fırlat
        return categoryRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Category category) {
        categoryRepository.save(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Category categoryToDelete = categoryRepository.findById(id).orElseThrow();
        // exception fırlaması = bu satırın çalışmaması
        // bu satıra geldiyse, bu id ile bir veri vardır.
        categoryRepository.delete(categoryToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Category category) {
        Category categoryToUpdate = categoryRepository.findById(id).orElseThrow();
        categoryToUpdate.setName(category.getName());
        categoryRepository.save(categoryToUpdate);
    }
}
// http://localhost:8080/api/categories GET isteği yapmış oluyoruz

