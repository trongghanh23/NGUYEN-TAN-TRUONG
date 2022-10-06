package com.code_gym.castudy.service.impl;

import com.code_gym.castudy.model.employee.Employee;
import com.code_gym.castudy.repository.IEmployeeRepository;
import com.code_gym.castudy.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> findAllEmployee() {
        return iEmployeeRepository.findAll();
    }
}
