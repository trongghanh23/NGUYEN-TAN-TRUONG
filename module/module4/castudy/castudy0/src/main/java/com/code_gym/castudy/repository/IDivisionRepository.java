package com.code_gym.castudy.repository;

import com.code_gym.castudy.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository extends JpaRepository<Division,Integer> {
}
