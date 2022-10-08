package com.code_gym.castudy.dto;

import com.code_gym.castudy.common.CheckRegexCustomer;
import com.code_gym.castudy.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CustomerDto implements Validator {
    private Integer id;

    @NotBlank(message = "please enter")
    private String name;

    @NotBlank(message = "please enter")
    private String dateOfBirth;

    private Boolean gender;

    @NotBlank(message = "please enter")
    private String idCard;

    @NotBlank(message = "please enter")
    private String phoneNumber;

    @NotBlank(message = "please enter")
    @Email(message = "please enter abc@gmail..")
    private String email;

    @NotBlank(message = "please enter")
    private String address;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(String name, String dateOfBirth, Boolean gender, String idCard, String phoneNumber, String email, String address, CustomerType customerType) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;

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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto= (CustomerDto) target;
        CheckRegexCustomer.checkName(customerDto,errors);
        CheckRegexCustomer.checkIdCard(customerDto,errors);
        CheckRegexCustomer.checkPhoneNumber(customerDto,errors);
        CheckRegexCustomer.checkAge(customerDto,errors);

    }
}
