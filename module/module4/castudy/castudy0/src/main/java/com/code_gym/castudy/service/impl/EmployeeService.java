package com.code_gym.castudy.service.impl;

import com.code_gym.castudy.model.employee.Employee;
import com.code_gym.castudy.repository.IEmployeeRepository;
import com.code_gym.castudy.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAllEmployees(String name, Pageable pageable) {
        return iEmployeeRepository.findByNameEmployee(name, pageable);
    }

    @Override
    public void deleteId(Integer id) {
        iEmployeeRepository.deleteById(id);

    }

    @Override
    public Optional<Employee> getId(Integer id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }


}
