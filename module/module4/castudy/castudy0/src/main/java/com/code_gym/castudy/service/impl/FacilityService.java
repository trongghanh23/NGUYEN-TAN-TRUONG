package com.code_gym.castudy.service.impl;


import com.code_gym.castudy.model.facility.Facility;
import com.code_gym.castudy.repository.IFacilityRepository;
import com.code_gym.castudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }

    @Override
    public List<Facility> findAllFacility() {
        return iFacilityRepository.findAll();
    }

    @Override
    public Page<Facility> findAllSearchAndPaging(String nameFacility, Pageable pageable) {
        return iFacilityRepository.findAllByNameContaining(nameFacility,pageable);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);

    }

    @Override
    public Facility getId(Integer id) {
        return iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iFacilityRepository.deleteById(id);

    }

}