package com.code_gym.castudy.service;

import com.code_gym.castudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllSearchAndPaging(String nameCustomer, Pageable pageable);

    void save(Customer customer);

    Customer getId(Integer id);

    void delete(Integer id);





}