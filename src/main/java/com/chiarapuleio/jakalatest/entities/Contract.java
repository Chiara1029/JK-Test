package com.chiarapuleio.jakalatest.entities;

import com.chiarapuleio.jakalatest.entities.abstractClass.Customer;
import com.chiarapuleio.jakalatest.enums.ContractType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private ContractType contractType;
    private LocalDate startingDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Contract(ContractType contractType, LocalDate startingDate, Customer customer) {
        this.contractType = contractType;
        this.startingDate = startingDate;
        this.customer = customer;
    }
}
