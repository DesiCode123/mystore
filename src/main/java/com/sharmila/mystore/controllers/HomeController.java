package com.sharmila.mystore.controllers;

import com.sharmila.mystore.entities.Category;
import com.sharmila.mystore.entities.Product;
import com.sharmila.mystore.services.HomeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.web.bind.annotation.*;

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
        List<Product> productListByCategory = homeService.gelAllProductByCategory(categoryName);
        return productListByCategory;

    }

    @PostMapping("/addCategory")
    public void addCategory(@RequestBody Category c){
        homeService.saveCategory(c);
    }

    @GetMapping("/getOneCategory")
    public Category getOneCategory(@RequestParam Integer categoryId){
        Category oneCategory = homeService.getOneCategory(categoryId);
        return oneCategory;
    }

    @GetMapping("/getOneProduct")
    public Product getOneProduct(@RequestParam Integer productId){
        Product product1 = homeService.getOneProduct(productId);
        return product1;
    }

    @PostMapping("/addProduct")
    public void  addOneProduct(@RequestBody Product product){
        homeService.saveProduct(product);
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestParam Integer productId){
        homeService.deleteProduct(productId);
    }

    @DeleteMapping("/deleteCategory")
    public void deleteCategory(@RequestParam Integer categoryId){
        homeService.deleteCategory(categoryId);

    }

    @PutMapping("/updateCategory")
    public Category updateCategory(@RequestBody Category category){
       Category category1 = homeService.updateCategory(category);
       return category1;
    }


//updateproduct
}
