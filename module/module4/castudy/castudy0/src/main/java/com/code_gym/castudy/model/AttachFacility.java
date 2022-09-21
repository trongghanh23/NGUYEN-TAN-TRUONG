package com.code_gym.castudy.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "attachFacility")
public class AttachFacility {
    @Id
    private Integer id;
    private String name;
    private Double cost;
    private String unit;
    private String status;
    @OneToMany(mappedBy = "attachFacility")
    private List<ContractDetail>contractDetails;
}
