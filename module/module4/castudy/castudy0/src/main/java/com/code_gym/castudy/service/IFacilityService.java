package com.code_gym.castudy.service;

import com.code_gym.castudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);

    List<Facility> findAllFacility();

    Page<Facility> findAllSearchAndPaging(String nameFacility, Pageable pageable);

    void save(Facility facility);

    Facility getId(Integer id);

    void delete(Integer id);

    void updateFacility(Facility facility);

}