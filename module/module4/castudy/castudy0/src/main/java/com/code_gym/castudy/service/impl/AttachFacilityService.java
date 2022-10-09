package com.code_gym.castudy.service.impl;

import com.code_gym.castudy.model.AttachFacility;
import com.code_gym.castudy.repository.IAttachFacilityRepository;
import com.code_gym.castudy.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;

    @Override
    public List<AttachFacility> findAllAttachContract(Integer id) {
        return null;
    }

    @Override
    public AttachFacility findById(int id) {
        return iAttachFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }
}





