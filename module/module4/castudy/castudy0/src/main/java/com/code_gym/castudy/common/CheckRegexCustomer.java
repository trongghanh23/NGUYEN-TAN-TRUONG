package com.code_gym.castudy.common;

import com.code_gym.castudy.dto.CustomerDto;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class CheckRegexCustomer {
    public static void checkName(CustomerDto customerDto, Errors errors){

            if (!customerDto.getName().matches("^([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+))+$")){
                errors.rejectValue("name",
                        "create",
                        "No contain special characters and numbers, capitalize the first letter !");
            }

    }

    public static void checkIdCard(CustomerDto customerDto, Errors errors) {
            if (!customerDto.getIdCard().matches("^(\\d{9}|\\d{12})$")) {
                errors.rejectValue("idCard", "", "Wrong format ! include 9 or 12 numbers");
            }
        }


    public static void checkPhoneNumber(CustomerDto customerDto, Errors errors) {


            if (!customerDto.getPhoneNumber().matches("^(090|091|8490|8491)\\d{7}$")) {
                errors.rejectValue("phoneNumber",
                        "",
                        "Wrong format ! ex: include 10 or 11 numbers. Start with 090 - 091 - 8490 - 8491");
            }

    }


    public static void checkAge(CustomerDto customerDto, Errors errors) {


            try {
                LocalDate age = LocalDate.parse(customerDto.getDateOfBirth());

                int checkAge = Period.between(age, LocalDate.now()).getYears();

                if (checkAge < 18) {
                    errors.rejectValue("dateOfBirth",
                            "",
                            "please enter age > 18 years old !");
                }
            } catch (DateTimeParseException e) {
                errors.rejectValue("dateOfBirth",
                        "",
                        "Wrong format !");
            }

    }
}
