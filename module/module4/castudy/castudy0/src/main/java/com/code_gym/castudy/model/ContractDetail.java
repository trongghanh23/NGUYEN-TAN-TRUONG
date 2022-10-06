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

    public ContractDetail() {
    }

    public ContractDetail(Integer id, Integer quantity, AttachFacility attachFacility, Contract contract) {
        this.id = id;
        this.quantity = quantity;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
