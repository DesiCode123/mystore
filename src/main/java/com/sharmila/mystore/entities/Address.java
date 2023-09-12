package com.sharmila.mystore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    private int addressId;
    private String streetName;
    private int zipCode;


}
