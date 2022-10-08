package com.code_gym.castudy.service.impl;

import com.code_gym.castudy.model.employee.EducationDegree;
import com.code_gym.castudy.repository.IEducationDegreeRepository;
import com.code_gym.castudy.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IEducationService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAllEducation() {
        return iEducationDegreeRepository.findAll();
    }
}
