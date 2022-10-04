package com.code_gym.castudy.service.impl;

import com.code_gym.castudy.model.facility.RentType;
import com.code_gym.castudy.repository.IRentTypeRepository;
import com.code_gym.castudy.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}