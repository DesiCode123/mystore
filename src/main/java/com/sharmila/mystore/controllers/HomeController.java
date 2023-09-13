package com.sharmila.mystore.controllers;

import com.sharmila.mystore.entities.Category;
import com.sharmila.mystore.entities.Product;
import com.sharmila.mystore.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/allProducts")
    public List<Product> getAllProducts() {
        List<Product> allProducts = homeService.getProducts();
        return allProducts;

    }


    @GetMapping("/allCategories")
    public List<Category> getAllCategories() {
        List<Category> allCategories = homeService.getCategories();
        return allCategories;
    }

    @GetMapping("/getProductsByCategory")
    public List<Product> getProductsByCategory(@RequestParam String categoryName) {
        return null;
    }

}
