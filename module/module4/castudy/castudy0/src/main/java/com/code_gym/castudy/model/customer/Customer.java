package com.code_gym.castudy.model.customer;

import com.code_gym.castudy.model.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dateOfBirth;
    private Boolean gender;
    private Integer idCard;
    private Integer phoneNumber;
    private String email;
    private String address;
    @JoinColumn(name = "customerType",referencedColumnName = "id")
    @ManyToOne
    private CustomerType customType;

    @OneToMany(mappedBy = "customer")
    private List<Contract>contractList;

}
