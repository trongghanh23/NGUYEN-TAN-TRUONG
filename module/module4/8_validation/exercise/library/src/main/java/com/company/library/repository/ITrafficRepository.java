package com.company.library.repository;

import com.company.library.model.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrafficRepository  extends JpaRepository<Traffic, Integer> {
}