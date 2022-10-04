package com.code_gym.castudy.service.impl;

import com.code_gym.castudy.model.facility.FacilityType;
import com.code_gym.castudy.repository.IFacilityTypeRepository;
import com.code_gym.castudy.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }
}