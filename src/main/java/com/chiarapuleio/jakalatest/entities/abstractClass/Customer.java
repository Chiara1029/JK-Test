package com.chiarapuleio.jakalatest.entities.abstractClass;

import com.chiarapuleio.jakalatest.entities.Contract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    protected UUID id;
    protected String address;
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    protected List<Contract> contracts;

    public Customer(String address) {
        this.address = address;
    }
}
