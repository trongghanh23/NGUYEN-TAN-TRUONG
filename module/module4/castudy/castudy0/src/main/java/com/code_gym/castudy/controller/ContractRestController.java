package com.code_gym.castudy.controller;

import com.code_gym.castudy.model.AttachFacility;
import com.code_gym.castudy.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restContract")
public class ContractRestController {

    @Autowired
    private IAttachFacilityService attachContractService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<AttachFacility>> showModalContractDetail(@PathVariable Integer id){

        List<AttachFacility> allAttachContract = attachContractService.findAllAttachContract(id);

        if (allAttachContract.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(allAttachContract, HttpStatus.OK);
    }
}