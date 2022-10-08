package com.code_gym.castudy.service.impl;

import com.code_gym.castudy.model.employee.Division;
import com.code_gym.castudy.repository.IDivisionRepository;
import com.code_gym.castudy.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAllDivision() {
        return iDivisionRepository.findAll();
    }
}

