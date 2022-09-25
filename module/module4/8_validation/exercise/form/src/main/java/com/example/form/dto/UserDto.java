package com.example.form.dto;

import com.example.form.common.DateTime;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private Integer id;

    @NotBlank(message = "please input!")
    @Size(min = 5, max = 45)
    @Pattern(regexp = "[A-Za-z ]+",message = "lease input! 5-45 character")
    private String firstName;

    @NotBlank(message = "please input!")
    @Size(min = 5, max = 45)
    @Pattern(regexp = "[A-Za-z ]+",message = "lease input! 5-45 character")
    private String lastName;

    @NotBlank(message = "please input!")
    @Pattern(regexp = "^(0([0-9]{9}))$", message = "Wrong format (0xxxxxxxxx)")
    private String phoneNumber;

    private String age;

    @NotBlank(message = "please input!")
    @Email(message = "please input again?")
    private String email;

    public UserDto() {
    }


    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        DateTime.checkAge(userDto, errors);

    }
}
