package com.sharmila.mystore.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private int totalPrice;

    private int tax;

    @ManyToMany
    @JoinTable(name= "order_products",joinColumns = @JoinColumn(name = "orderId"),inverseJoinColumns = @JoinColumn(name = "productId"))
    private Set<Product> products = new LinkedHashSet<>();// har rekkefølge,hashset har ikke rekkfølge

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "addressId")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "paymentId")
    private Payment payment;





}
