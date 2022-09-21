package com.code_gym.castudy.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "division")
public class Division {
    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "division")
    private List<Employee>employeeList;
}
