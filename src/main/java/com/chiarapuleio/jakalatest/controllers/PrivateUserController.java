package com.chiarapuleio.jakalatest.controllers;

import com.chiarapuleio.jakalatest.entities.PrivateUser;
import com.chiarapuleio.jakalatest.payloads.PrivateUserDTO;
import com.chiarapuleio.jakalatest.services.PrivateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/private")
public class PrivateUserController {
    @Autowired
    private PrivateUserService privateUserSrv;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrivateUser saveUser(@RequestBody PrivateUserDTO user) {
        return privateUserSrv.save(user);
    }

    @GetMapping
    public List<PrivateUser> getPrivateUsers() {
        return privateUserSrv.getPrivateUsers();
    }

    @GetMapping("/{userId}")
    public PrivateUser findById(@PathVariable UUID userId) {
        return privateUserSrv.findById(userId);
    }
}
