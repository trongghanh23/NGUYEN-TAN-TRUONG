package com.code_gym.castudy.service.impl;


import com.code_gym.castudy.model.customer.Customer;
import com.code_gym.castudy.repository.ICustomerRepository;
import com.code_gym.castudy.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllSearchAndPaging(String nameCustomer, Pageable pageable) {
        return iCustomerRepository.findAllByNameContaining(nameCustomer,pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer getId(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iCustomerRepository.deleteById(id);
    }


}