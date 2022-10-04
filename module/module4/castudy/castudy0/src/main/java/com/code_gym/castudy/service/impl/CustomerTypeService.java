package com.code_gym.castudy.service.impl;

import com.code_gym.castudy.model.customer.CustomerType;
import com.code_gym.castudy.repository.ICustomerTypeRepository;
import com.code_gym.castudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

}