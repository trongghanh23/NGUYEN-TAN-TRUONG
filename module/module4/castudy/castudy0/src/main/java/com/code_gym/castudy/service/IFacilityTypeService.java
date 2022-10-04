package com.code_gym.castudy.service;

import com.code_gym.castudy.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
}