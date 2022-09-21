package com.code_gym.castudy.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {
    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "position")
    private List<Employee>employeeList;

}
