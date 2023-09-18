package com.sharmila.mystore.services;

import com.sharmila.mystore.entities.Category;
import com.sharmila.mystore.entities.Product;
import com.sharmila.mystore.repositories.CategoryRepository;
import com.sharmila.mystore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Product getOneProduct(Integer productId){
        Product product1 = productRepository.findById(productId).get();
        return product1;
    }
    @Transactional
    public void saveProduct(Product product){
        Optional<Category> category = categoryRepository.findById(product.getCategory().getCategoryId());
        if(category.isPresent()){
            Category categor1 = category.get();
            product.setCategory(categor1);
            categor1.getProducts().add(product);
            productRepository.save(product);
        }else{
            throw new RuntimeException("no category found");
        }

    }

    public void deleteProduct(Integer productId){
        productRepository.deleteById(productId);
    }

    public void deleteCategory(Integer categoryId){
        categoryRepository.deleteById(categoryId);
    }

    public Category updateCategory(Category category) {
        Category category1 = categoryRepository.save(category);
        return category1;

    }
}
