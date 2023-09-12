package com.sharmila.mystore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    private int paymentId;
    private String name;
    private int cardNr;
    private int expireDate;
    private int cvv;

}
