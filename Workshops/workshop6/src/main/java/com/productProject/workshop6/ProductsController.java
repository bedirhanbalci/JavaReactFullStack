package com.productProject.workshop6;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {
    private List<Product> productList = new ArrayList<>();

    @GetMapping
    public List<Product> getAllProduct() {
        return productList;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        boolean isUnique = productList.stream().noneMatch(product1 -> product1.getId() == product.getId());

        if (isUnique) {
            productList.add(product);
        } else {
            throw new RuntimeException("not unique");
        }
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}