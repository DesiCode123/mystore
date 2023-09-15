package com.sharmila.mystore.repositories;

import com.sharmila.mystore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);


}
