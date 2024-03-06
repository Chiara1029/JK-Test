package com.chiarapuleio.jakalatest.services;

import com.chiarapuleio.jakalatest.entities.BusinessUser;
import com.chiarapuleio.jakalatest.entities.Contract;
import com.chiarapuleio.jakalatest.entities.PrivateUser;
import com.chiarapuleio.jakalatest.enums.ContractType;
import com.chiarapuleio.jakalatest.exceptions.BadRequestException;
import com.chiarapuleio.jakalatest.exceptions.NotFoundException;
import com.chiarapuleio.jakalatest.payloads.ContractDTO;
import com.chiarapuleio.jakalatest.respositories.ContractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ContractService {
    @Autowired
    private ContractDAO contractDAO;
    @Autowired
    private PrivateUserService privateUserSrv;
    @Autowired
    private BusinessUserService businessUserSrv;

    public List<Contract> getContracts(){
        return this.contractDAO.findAll();
    }

    public Contract findById(UUID id){
        return this.contractDAO.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public Contract savePrivate(ContractDTO contract){
        PrivateUser customer = privateUserSrv.findById(contract.customerId());
        Contract newContract = new Contract();
        newContract.setContractType(contract.contractType());
        newContract.setStartingDate(contract.startingDate());
        newContract.setCustomer(customer);

        return contractDAO.save(newContract);
    }

    public Contract saveBusiness(ContractDTO contract){
        BusinessUser customer = businessUserSrv.findById(contract.customerId());
        Contract newContract = new Contract();
        newContract.setContractType(contract.contractType());
        newContract.setStartingDate(contract.startingDate());
        newContract.setCustomer(customer);

        return contractDAO.save(newContract);
    }

    public List<Contract> filterByStartingDate(LocalDate date){
        return contractDAO.findByStartingDate(date);
    }

    public List<Contract> filterByType(String contractType){
        String type = contractType.toUpperCase();
        if(type.equals("GAS") || type.equals("ELECTRICITY") || type.equals("GAS_AND_ELECTRICITY")){
            return contractDAO.findByContractType(ContractType.valueOf(type));
        } else throw new BadRequestException("Invalid type. Use type: GAS, ELECTRICITY or GAS_AND_ELECTRICITY");
    }

    public List<Contract> filterByNameAndLastName(String name, String lastName){
        return contractDAO.findByNameAndLastName(name, lastName);
    }

    public List<Contract> filterByBusinessName(String businessName){
        return contractDAO.findByBusinessName(businessName);
    }

    public List<Contract> filterByPrivateUser(){
        return contractDAO.findByPrivateUser();
    }

    public List<Contract> filterByBusinessUser(){
        return contractDAO.findByBusinessUser();
    }
}
