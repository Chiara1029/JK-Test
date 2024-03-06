package com.chiarapuleio.jakalatest.entities;

import com.chiarapuleio.jakalatest.entities.abstractClass.Customer;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("PRIVATE")
public class PrivateUser extends Customer {
    private String name;
    private String lastName;
    private String taxCode;

    public PrivateUser(String address, String name, String lastName, String taxCode) {
        super(address);
        this.name = name;
        this.lastName = lastName;
        this.taxCode = taxCode;
    }
}
