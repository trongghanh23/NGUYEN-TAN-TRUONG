package com.code_gym.castudy.service.impl;

import com.code_gym.castudy.model.employee.Position;
import com.code_gym.castudy.repository.IPositionRepository;
import com.code_gym.castudy.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository  iPositionRepository;
    @Override
    public List<Position> findAllPosition() {
        return iPositionRepository.findAll();


    }
}
