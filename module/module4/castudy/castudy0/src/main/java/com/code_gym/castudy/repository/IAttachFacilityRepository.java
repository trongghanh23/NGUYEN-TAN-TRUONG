package com.code_gym.castudy.repository;

import com.code_gym.castudy.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
//    @Query(value = "SELECT * " +
//            "FROM attach_facility  " +
//            "JOIN contrac_detail  ON contrac_detail.attach_facility = attach_facility.id " +
//            "JOIN contract ON contrac_detail.contract = contract.id " +
//            "WHERE contract.id = :id ", nativeQuery = true)
//    List<AttachFacility> findAttachContract(@Param("id") Integer id);
}
