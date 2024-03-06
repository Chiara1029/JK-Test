package com.chiarapuleio.jakalatest.services;

import com.chiarapuleio.jakalatest.entities.BusinessUser;
import com.chiarapuleio.jakalatest.exceptions.BadRequestException;
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

    public List<BusinessUser> getBusinessUsers(){
        return this.businessUserDAO.findAll();
    }

    public BusinessUser findById(UUID id){
        return businessUserDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BusinessUser save(BusinessUserDTO user){
        if(businessUserDAO.existsByVatNumber(user.vatNumber())) throw new BadRequestException("This VAT number already exist.");
        BusinessUser newUser = new BusinessUser(user.address(), user.businessName(), user.vatNumber());
        return businessUserDAO.save(newUser);
    }
}
