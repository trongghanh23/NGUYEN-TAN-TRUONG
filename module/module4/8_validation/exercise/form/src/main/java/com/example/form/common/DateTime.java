package com.example.form.common;

import com.example.form.dto.UserDto;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.time.Period;

public class DateTime {

    public static void checkAge(UserDto userDto, Errors errors) {

        try {
            String age = userDto.getAge();
            LocalDate localDate = LocalDate.parse(age);
            int checkAge = Period.between(localDate, LocalDate.now()).getYears();
            if (checkAge < 18 && checkAge <= 100) {
                errors.rejectValue("age", "", "age >18 and age <=100");
            }
        } catch (Exception e) {
            errors.rejectValue("age", "", "please input");
        }

    }

}
