package com.code_gym.castudy.model.employee;

import com.code_gym.castudy.model.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EmployeeController")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dateOfBirth;
    private Integer idCard;
    private Double salary;
    private Integer phoneNumber;
    private String email;
    private String address;
    @JoinColumn(name = "division",referencedColumnName = "id")
    @ManyToOne
    private Division division;
    @JoinColumn(name = "educationDegree",referencedColumnName = "id")
    @ManyToOne
    private EducationDegree educationDegree;

    @JoinColumn(name ="positon",referencedColumnName = "id")
    @ManyToOne
    private Position position;

    @OneToMany(mappedBy = "employee")
    private List<Contract>contractList;

}
