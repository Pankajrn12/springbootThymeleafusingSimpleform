package com.thymeleafSimple.thymeleafSimplrProject.repositories;

import com.thymeleafSimple.thymeleafSimplrProject.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
