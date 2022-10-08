package com.code_gym.castudy.repository;

import com.code_gym.castudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value="select * from employee_controller where  `name` like %:key% and is_delete=0", nativeQuery=true)
        Page<Employee> findByNameEmployee(@Param("key")String search, Pageable pageable);

    @Modifying
    @Query(value="update employee_controller set is_delete = 1 where id =:keyss", nativeQuery=true)
    void deleteById(@Param("keyss") Integer id);
}
