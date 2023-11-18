package com.productProject.workshop6;

public class Product {
    private int id;
    private int price;
    private String name;
    private String description;
    private String categoryName;

    public Product() {

    }

    public Product(int id, int price, String name, String description, String categoryName) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
