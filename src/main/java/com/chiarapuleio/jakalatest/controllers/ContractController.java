package com.chiarapuleio.jakalatest.controllers;

import com.chiarapuleio.jakalatest.entities.Contract;
import com.chiarapuleio.jakalatest.payloads.ContractDTO;
import com.chiarapuleio.jakalatest.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private ContractService contractSrv;

    @PostMapping("/private")
    @ResponseStatus(HttpStatus.CREATED)
    public Contract savePrivate(@RequestBody ContractDTO contract){
        return contractSrv.savePrivate(contract);
    }

    @PostMapping("/business")
    @ResponseStatus(HttpStatus.CREATED)
    public Contract saveBusiness(@RequestBody ContractDTO contract){
        return contractSrv.saveBusiness(contract);
    }

    @GetMapping
    public List<Contract> getContracts(){
        return contractSrv.getContracts();
    }

    @GetMapping("/{contractId}")
    public Contract findById(@PathVariable UUID contractId){
        return contractSrv.findById(contractId);
    }
}