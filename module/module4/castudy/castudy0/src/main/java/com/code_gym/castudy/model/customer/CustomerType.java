package com.code_gym.castudy.model.customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customerType")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "customType")
    private List<Customer>customerList;
}
