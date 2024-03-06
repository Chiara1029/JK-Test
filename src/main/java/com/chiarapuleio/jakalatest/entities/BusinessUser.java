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
@DiscriminatorValue("BUSINESS")
public class BusinessUser extends Customer {
    private String businessName;
    private Long vatNumber;

    public BusinessUser(String address, String businessName, Long vatNumber) {
        super(address);
        this.businessName = businessName;
        this.vatNumber = vatNumber;
    }
}
