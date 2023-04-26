package com.thymeleafSimple.thymeleafSimplrProject.controller;

import com.thymeleafSimple.thymeleafSimplrProject.Models.ProductModel;
import com.thymeleafSimple.thymeleafSimplrProject.entities.Products;
import com.thymeleafSimple.thymeleafSimplrProject.repositories.ProductRepository;
import com.thymeleafSimple.thymeleafSimplrProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model m){
        List<Products> list= productRepository.findAll();
        m.addAttribute("get_Product",list);
        return "index";
    }
    @GetMapping("/load-form")
    public String loadForm(){
        return "add";
    }

    @GetMapping("/edit-form")
    public String editForm(){
        return "edit";
    }

    @PostMapping("/save_Product")
    public ResponseEntity saveProduct(@ModelAttribute ProductModel productModel , HttpSession session){
        session.setAttribute("msg", "Product Added SuccessFully........");
        return productService.saveProduct(productModel);
    }

    @GetMapping("get_Products")
    List<ProductModel> get_Products(ProductModel productModel){
        return productService.get_Products();

    }
}
