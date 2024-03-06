package com.chiarapuleio.jakalatest.respositories;

import com.chiarapuleio.jakalatest.entities.PrivateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrivateUserDAO extends JpaRepository<PrivateUser, UUID> {
}
