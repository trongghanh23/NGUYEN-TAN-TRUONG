package com.code_gym.castudy.repository;

import com.code_gym.castudy.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {
}
