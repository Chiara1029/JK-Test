package com.chiarapuleio.jakalatest.controllers;

import com.chiarapuleio.jakalatest.entities.BusinessUser;
import com.chiarapuleio.jakalatest.exceptions.BadRequestException;
import com.chiarapuleio.jakalatest.payloads.BusinessUserDTO;
import com.chiarapuleio.jakalatest.services.BusinessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/business")
public class BusinessUserController {
    @Autowired
    private BusinessUserService businessUserSrv;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BusinessUser saveUser(@RequestBody BusinessUserDTO user) throws Exception{
        try{
            return businessUserSrv.save(user);
        } catch (Exception ex){
            throw new BadRequestException(ex.getMessage());
        }
    }

    @GetMapping
    public List<BusinessUser> getBusinessUsers(){
        return businessUserSrv.getBusinessUsers();
    }

    @GetMapping("/{userId}")
    public BusinessUser findById(@PathVariable UUID userId){
        return businessUserSrv.findById(userId);
    }
}
