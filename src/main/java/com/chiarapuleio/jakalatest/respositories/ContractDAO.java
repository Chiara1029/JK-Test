package com.chiarapuleio.jakalatest.respositories;

import com.chiarapuleio.jakalatest.entities.Contract;
import com.chiarapuleio.jakalatest.enums.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ContractDAO extends JpaRepository<Contract, UUID> {
    List<Contract> findByStartingDate(LocalDate startingDate);

    List<Contract> findByContractType(ContractType contractType);

    @Query("SELECT c FROM Contract c JOIN PrivateUser p ON c.customer.id = p.id WHERE p.name = :name AND p.lastName = :lastName")
    List<Contract> findByNameAndLastName(String name, String lastName);

    @Query("SELECT c FROM Contract c JOIN BusinessUser b ON c.customer.id = b.id WHERE b.businessName = :businessName")
    List<Contract> findByBusinessName(String businessName);
}
