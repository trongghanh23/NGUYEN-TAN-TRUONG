package com.codegym.smartphone.repository;

import com.codegym.smartphone.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long > {
}
