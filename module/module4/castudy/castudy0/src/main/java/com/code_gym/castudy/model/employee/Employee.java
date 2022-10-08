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
    private  int isDelete;

    @JoinColumn(name = "division",referencedColumnName = "id")
    @ManyToOne
    private Division division;
    @JoinColumn(name = "educationDegree",referencedColumnName = "id")
    @ManyToOne()
    private EducationDegree educationDegree;

    @JoinColumn(name ="positon",referencedColumnName = "id")
    @ManyToOne
    private Position position;

    @OneToMany(mappedBy = "employee")
    private List<Contract>contractList;

    public Employee() {
    }

    public Employee(Integer id, String name, String dateOfBirth, Integer idCard, Double salary, Integer phoneNumber, String email, String address, int isDelete, Division division, EducationDegree educationDegree, Position position, List<Contract> contractList) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.isDelete = isDelete;
        this.division = division;
        this.educationDegree = educationDegree;
        this.position = position;
        this.contractList = contractList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
