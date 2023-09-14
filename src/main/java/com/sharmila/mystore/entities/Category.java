package com.sharmila.mystore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generation of primarykey
    private int categoryId;

    private String name;

    @OneToMany(mappedBy = "category",orphanRemoval = true)
    @JsonIgnore
    private Set<Product> products = new LinkedHashSet<>();


}
