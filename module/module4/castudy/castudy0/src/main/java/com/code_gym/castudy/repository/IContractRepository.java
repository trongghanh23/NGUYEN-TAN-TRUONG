package com.code_gym.castudy.repository;

import com.code_gym.castudy.dto.IContractDto;
import com.code_gym.castudy.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;

@Controller
public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "SELECT \n" +
            "facility.`name` as facilityName,\n" +
            "customer.`name` as customerName,\n" +
            "    contract.deposit,\n" +
            "    contract.star_date as startDate,\n" +
            "   contract.end_date as endDate,\n" +
            "    (IFNULL(facility.cost, 0) + IFNULL((contrac_detail.quantity * attach_facility.cost),\n" +
            "            0)) AS total\n" +
            "FROM\n" +
            "   customer\n" +
            "         LEFT JOIN\n" +
            "    contract ON customer.id = contract.customer\n" +
            "         LEFT JOIN\n" +
            "    facility ON contract.facility = facility.id\n" +
            "         LEFT JOIN\n" +
            "    contrac_detail ON contrac_detail .contract = contract.id\n" +
            "        LEFT  JOIN\n" +
            "    attach_facility ON contrac_detail.attach_facility = attach_facility.id\n" +
            "GROUP BY contract.id",
            countQuery = "SELECT count(*) "+
                    "FROM\n" +
                    "   customer\n" +
                    "         LEFT JOIN\n" +
                    "    contract ON customer.id = contract.customer\n" +
                    "         LEFT JOIN\n" +
                    "    facility ON contract.facility = facility.id\n" +
                    "         LEFT JOIN\n" +
                    "    contrac_detail ON contrac_detail .contract = contract.id\n" +
                    "        LEFT  JOIN\n" +
                    "    attach_facility ON contrac_detail.attach_facility = attach_facility.id\n" +
                    "GROUP BY contract.id",nativeQuery = true)
    Page<IContractDto> findAllByName(Pageable pageable);

}
