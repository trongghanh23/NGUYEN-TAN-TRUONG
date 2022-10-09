package com.code_gym.castudy.service;

import com.code_gym.castudy.model.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAllAttachContract(Integer id);
    AttachFacility findById(int id);
    List<AttachFacility> findAll();
}
