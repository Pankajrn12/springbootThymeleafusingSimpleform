package com.thymeleafSimple.thymeleafSimplrProject.services;

import com.thymeleafSimple.thymeleafSimplrProject.Models.ProductModel;
import com.thymeleafSimple.thymeleafSimplrProject.entities.Products;
import com.thymeleafSimple.thymeleafSimplrProject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional
    public ResponseEntity saveProduct(ProductModel productModel) {
        Products products = new Products();
        products.setProductName(productModel.getProductName());
        products.setId(productModel.getId());
        products.setDescription(productModel.getDescription());
        products.setQuantity(productModel.getQuantity());
        products.setPrice(productModel.getPrice());


        productRepository.save(products);



        return new ResponseEntity<>("All Product Added SuccessFully", HttpStatus.OK);
    }




    public List<ProductModel> get_Products() {
        List<ProductModel> productModelList = new ArrayList<>();
        List<Products> productsList = productRepository.findAll();

        productsList.stream().forEach(data->{
            ProductModel model = new ProductModel();
            model.setPrice(data.getPrice());
            model.setProductName(data.getProductName());
            model.setDescription(data.getDescription());
            model.setId(data.getId());
            model.setQuantity(data.getQuantity());

            productModelList.add(model);
        });
        return productModelList;
    }
}
