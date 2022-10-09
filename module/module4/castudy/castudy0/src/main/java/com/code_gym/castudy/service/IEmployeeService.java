package com.code_gym.castudy.service;

import com.code_gym.castudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee>findAll();

    Page<Employee> findAllEmployees(String name, Pageable pageable);

    void deleteId(Integer id);

    Optional<Employee> getId(Integer id);

    void save(Employee employee);



}
