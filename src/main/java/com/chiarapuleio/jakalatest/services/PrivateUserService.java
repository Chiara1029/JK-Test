package com.chiarapuleio.jakalatest.services;

import com.chiarapuleio.jakalatest.entities.PrivateUser;
import com.chiarapuleio.jakalatest.exceptions.BadRequestException;
import com.chiarapuleio.jakalatest.exceptions.NotFoundException;
import com.chiarapuleio.jakalatest.payloads.PrivateUserDTO;
import com.chiarapuleio.jakalatest.respositories.PrivateUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrivateUserService {
    @Autowired
    private PrivateUserDAO privateUserDAO;

    public List<PrivateUser> getPrivateUsers(){
        return this.privateUserDAO.findAll();
    }

    public PrivateUser findById(UUID id){
        return privateUserDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public PrivateUser save(PrivateUserDTO user){
        if(privateUserDAO.existsByTaxCode(user.taxCode())) throw new BadRequestException("This tax code already exist.");
        PrivateUser newUser = new PrivateUser(user.name(), user.lastName(), user.taxCode(), user.address());
        return privateUserDAO.save(newUser);
    }
}
