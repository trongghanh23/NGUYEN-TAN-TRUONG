package com.code_gym.castudy.service;

import com.code_gym.castudy.dto.IContractDto;
import com.code_gym.castudy.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<IContractDto> findByNameContract(Pageable pageable);
    void save(Contract contract);
}
