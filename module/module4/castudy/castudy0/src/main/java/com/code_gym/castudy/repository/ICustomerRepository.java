package com.code_gym.castudy.repository;

import com.code_gym.castudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByNameContaining(String nameCustomer, Pageable pageable);

//    @Query(value="select * from customer where  name like %:key% and is_delete=0", nativeQuery=true)
//    Page<Customer> findByNameCustomer(@Param("key")String search,Pageable pageable);
//    @Modifying
//     @Query(value="update customer set is_delete= 1 where id=:keyss", nativeQuery=true)
//    void deleteById(@Param("keyss") Integer id);

}