package com.code_gym.castudy.repository;

import com.code_gym.castudy.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    List<ContractDetail> findAllByContract_id(Integer id);
}
