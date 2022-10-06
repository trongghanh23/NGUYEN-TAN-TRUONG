package com.code_gym.castudy.service;

import com.code_gym.castudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);
    List<Customer>findAllCustomer();

    Page<Customer> findAllSearchAndPaging(String nameCustomer, Pageable pageable);

    void save(Customer customer);

    Customer getId(Integer id);

    void delete(Integer id);





}