package com.code_gym.castudy.service.impl;

import com.code_gym.castudy.dto.IContractDto;
import com.code_gym.castudy.model.Contract;
import com.code_gym.castudy.repository.IContractRepository;
import com.code_gym.castudy.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<IContractDto> findByNameContract(Pageable pageable) {
        return iContractRepository.findAllByName(pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }
}
