package com.chiarapuleio.jakalatest.services;

import com.chiarapuleio.jakalatest.entities.BusinessUser;
import com.chiarapuleio.jakalatest.entities.Contract;
import com.chiarapuleio.jakalatest.entities.PrivateUser;
import com.chiarapuleio.jakalatest.exceptions.NotFoundException;
import com.chiarapuleio.jakalatest.payloads.ContractDTO;
import com.chiarapuleio.jakalatest.respositories.ContractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
