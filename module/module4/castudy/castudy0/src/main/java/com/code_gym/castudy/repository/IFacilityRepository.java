package com.code_gym.castudy.repository;
import com.code_gym.castudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    Page<Facility> findAllByNameContaining(String nameFacility, Pageable pageable);
}