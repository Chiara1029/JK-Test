package com.chiarapuleio.jakalatest.respositories;

import com.chiarapuleio.jakalatest.entities.BusinessUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BusinessUserDAO extends JpaRepository<BusinessUser, UUID> {
    boolean existsByVatNumber(Long vatNumber);
}
