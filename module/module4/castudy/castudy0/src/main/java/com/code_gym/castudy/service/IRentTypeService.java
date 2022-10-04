package com.code_gym.castudy.service;

import com.code_gym.castudy.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}