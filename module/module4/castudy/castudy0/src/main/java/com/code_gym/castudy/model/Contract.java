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
    private Double total;

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

    public Contract() {
    }

    public Contract(Integer id, String starDate, String endDate, Double deposit, Double total, Customer customer, Employee employee, Facility facility, List<ContractDetail> contractDetailList) {
        this.id = id;
        this.starDate = starDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.total = total;
        this.customer = customer;
        this.employee = employee;
        this.facility = facility;
        this.contractDetailList = contractDetailList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
