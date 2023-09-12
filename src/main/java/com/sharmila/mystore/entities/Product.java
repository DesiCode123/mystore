package com.sharmila.mystore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    private int productId;
    private String name;
    private String description;
    private String pageUrl;
}
