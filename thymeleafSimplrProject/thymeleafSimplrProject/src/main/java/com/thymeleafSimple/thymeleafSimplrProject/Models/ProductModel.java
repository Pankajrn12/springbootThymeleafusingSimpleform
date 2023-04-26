package com.thymeleafSimple.thymeleafSimplrProject.Models;

import lombok.Data;

@Data
public class ProductModel {
    private Long id;
    private String productName;
    private String description;
    private String price;
    private String quantity;

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
