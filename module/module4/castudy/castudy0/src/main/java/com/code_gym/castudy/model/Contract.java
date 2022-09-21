package com.code_gym.castudy.model;

import com.code_gym.castudy.model.customer.Customer;
import com.code_gym.castudy.model.employee.Employee;
import com.code_gym.castudy.model.facility.Facility;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String starDate;
    private String endDate;
    private Double deposit;
    @JoinColumn(name = "customer",referencedColumnName = "id")
    @ManyToOne
    private Customer customer;
    @JoinColumn(name = "employee",referencedColumnName = "id")
    @ManyToOne
    private Employee employee;

    @JoinColumn(name = "facility",referencedColumnName = "id")
    @ManyToOne
    private Facility facility;

    @OneToMany(mappedBy = "contract")
    private List<ContractDetail>contractDetailList;
}
