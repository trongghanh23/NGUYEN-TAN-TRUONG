package com.code_gym.castudy.model;

import javax.persistence.*;

@Entity
@Table(name = "contracDetail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    @JoinColumn(name = "attachFacility",referencedColumnName = "id")
    @ManyToOne
    private AttachFacility attachFacility;


  @JoinColumn(name = "contract",referencedColumnName = "id")
    @ManyToOne
    private Contract contract;




}
