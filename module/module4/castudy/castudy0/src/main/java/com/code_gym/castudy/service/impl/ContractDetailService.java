package com.code_gym.castudy.service.impl;

import com.code_gym.castudy.model.ContractDetail;
import com.code_gym.castudy.repository.IContractDetailRepository;
import com.code_gym.castudy.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public List<ContractDetail> findAllDetail() {
        return iContractDetailRepository.findAll();
    }
}
