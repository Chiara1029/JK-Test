package com.chiarapuleio.jakalatest.entities;

import com.chiarapuleio.jakalatest.entities.abstractClass.Customer;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Contract {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
