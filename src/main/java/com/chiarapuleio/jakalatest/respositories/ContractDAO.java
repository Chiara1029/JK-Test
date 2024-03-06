package com.chiarapuleio.jakalatest.respositories;

import com.chiarapuleio.jakalatest.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ContractDAO extends JpaRepository<Contract, UUID> {
    List<Contract> findByStartingDate(LocalDate startingDate);
}
