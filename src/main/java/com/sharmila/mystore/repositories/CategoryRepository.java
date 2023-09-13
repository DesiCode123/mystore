package com.sharmila.mystore.repositories;

import com.sharmila.mystore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Category findByName(String name);

}
