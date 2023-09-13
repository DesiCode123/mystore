package com.sharmila.mystore.services;

import com.sharmila.mystore.entities.Category;
import com.sharmila.mystore.entities.Product;
import com.sharmila.mystore.repositories.CategoryRepository;
import com.sharmila.mystore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getProducts(){
       List<Product> allProducts = productRepository.findAll();
       return allProducts;
    }

    public List<Category> getCategories(){
        List<Category> allCategory = categoryRepository.findAll();
        return allCategory;
    }

    public List<Product> gelAllProductByCategory(String categoryName){
        Category category = categoryRepository.findByName(categoryName);
        return

    }

}
