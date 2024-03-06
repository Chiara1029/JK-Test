package com.chiarapuleio.jakalatest.services;

import com.chiarapuleio.jakalatest.entities.BusinessUser;
import com.chiarapuleio.jakalatest.exceptions.NotFoundException;
import com.chiarapuleio.jakalatest.payloads.BusinessUserDTO;
import com.chiarapuleio.jakalatest.respositories.BusinessUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BusinessUserService {
    @Autowired
    private BusinessUserDAO businessUserDAO;

    public List<BusinessUser> getBusinessUser(){
        return this.businessUserDAO.findAll();
    }

    public BusinessUser findById(UUID id){
        return this.businessUserDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BusinessUser save(BusinessUserDTO user){
        BusinessUser newUser = new BusinessUser();
        newUser.setBusinessName(user.businessName());
        newUser.setVatNumber(user.vatNumber());
        newUser.setAddress(user.address());

        return businessUserDAO.save(newUser);
    }
}
