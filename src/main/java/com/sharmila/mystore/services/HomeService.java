package com.sharmila.mystore.services;

import com.sharmila.mystore.entities.Category;
import com.sharmila.mystore.entities.Product;
import com.sharmila.mystore.repositories.CategoryRepository;
import com.sharmila.mystore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Product> productsByCategory = new ArrayList<>(category.getProducts());
        return productsByCategory;

    }
    public void saveCategory(Category category){
        categoryRepository.save(category);
    }
    public Category getOneCategory(Integer category){
        Category category1 = categoryRepository.findById(category).get();
        return category1;
    }

    public Product getOneProduct(String name){
        Product product1 = productRepository.findByName(name);
        return product1;
    }
    public void saveProduct(Product product){
        productRepository.save(product);
    }
}
