package com.tobeto.rent.a.car.demo;

import com.tobeto.rent.a.car.demo.entities.Category;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Category> categories = new ArrayList<>();

        Category category1 = new Category();
        category1.setId(1);
        category1.setName("Sports");
        categories.add(category1);

        Category category2 = new Category();
        category2.setId(2);
        category2.setName("Crossover");
        categories.add(category2);

        Category category3 = new Category();
        category3.setId(3);
        category3.setName("SUV");
        categories.add(category3);

        // Lambda Expression = > Java 8
        categories.forEach((item) ->
        {
            String name = item.getName();
            System.out.println(name);
        });

        categories.forEach((item) -> System.out.println(item.getId())); // One line function

        // STREAM API

        // koleksiyonlar üzerinde işlem yapılmasını kolaylaştırır

        List<GetListCategoryResponse> result =
                        categories
                        .stream()
                        .map((category) -> new GetListCategoryResponse(category.getId(), category.getName())).toList();


        List<Category> sortedCategories = categories.stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).toList();
        sortedCategories.forEach((category -> System.out.println(category.getName())));

        System.out.println("*****************");

        // daha modern, daha yeni bir syntax. karşılaştırmaları artık bu şekilde kullanacağız

        List<Category> sortedCategories2 = categories.stream().sorted(Comparator.comparing(Category::getName).thenComparing(Category::getId)).toList();
        sortedCategories2.forEach((category -> System.out.println(category.getName())));


        System.out.println("**********************************");

        List<Category> filteredCategories = categories.stream().filter((category) -> category.getName().length() > 6).toList();
        System.out.println(filteredCategories.size());

        // Multiple Line lambda experssion'larda eğer method bir dönüş tipi bekliyor ise, return keyword'u kullanılmalı!

        List<Category> filteredCategories2 = categories.stream().filter((category) -> {
            int minLength = 2;
            return category.getId() > minLength && category.getName().equals("SUV");
        }).toList();
        System.out.println(filteredCategories2.size());



    }
}
