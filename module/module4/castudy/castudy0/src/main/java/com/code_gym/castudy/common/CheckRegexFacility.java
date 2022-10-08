package com.code_gym.castudy.common;

import com.code_gym.castudy.dto.FacilityDto;
import org.springframework.validation.Errors;

public class CheckRegexFacility {
    public static void checkName(FacilityDto facilityDto, Errors errors) {

        if (!facilityDto.getName().isEmpty()){
            if (!facilityDto.getName().matches("^([A-Z][a-z ]+)+[0-9]*$")){
                errors.rejectValue("name",
                        "name",
                        "No contain special characters, capitalize the first letter !");
            }
        }else {
            errors.rejectValue("name",
                    "name",
                    "Please enter !");
        }
    }
    public static void checkArea(FacilityDto facilityDto, Errors errors) {


        try {
            Double area = Double.parseDouble(String.valueOf(facilityDto.getArea()));

            if (area <= 0){
                errors.rejectValue("area",
                        "create",
                        "Please enter a positive number !");
            }
        }catch (Exception e){
            errors.rejectValue("area",
                    "area",
                    "Please enter a number !");
        }

    }

    public static void checkCost(FacilityDto facilityDto, Errors errors) {


        try {
            Double cost = Double.parseDouble(String.valueOf(facilityDto.getCost()));

            if (cost <= 0){
                errors.rejectValue("cost",
                        "create",
                        "Please enter a positive number !");
            }
        }catch (Exception e){
            errors.rejectValue("cost",
                    "create.cost",
                    "Please enter a number !");
        }

    }

    public static void checkMaxPeople(FacilityDto facilityDto, Errors errors) {

        try {
            Integer maxPeople = Integer.parseInt(String.valueOf(facilityDto.getMaxPeople()));

            if (maxPeople <= 0){
                errors.rejectValue("maxPeople",
                        "create",
                        "Please enter a positive number !");
            }
        }catch (Exception e){
            errors.rejectValue("maxPeople",
                    "create",
                    "Please enter a number !");
        }

    }

    public static void checkPoolArea(FacilityDto facilityDto, Errors errors) {

        try {
            Double poolArea = Double.parseDouble(String.valueOf(facilityDto.getPoolArea()));

            if (poolArea <= 0){
                errors.rejectValue("poolArea ",
                        "create",
                        "Please enter a positive number !");
            }
        }catch (Exception e){
            errors.rejectValue("poolArea",
                    "create",
                    "Please enter a positive number !");
        }

    }

    public static void checkFloors(FacilityDto facilityDto, Errors errors) {

        try {
            Integer floors = Integer.parseInt(String.valueOf(facilityDto.getNumberFloors()));

            if (floors <= 0){
                errors.rejectValue("numberFloors ",
                        "create",
                        "Please enter a positive number !");
            }
        }catch (Exception e){
            errors.rejectValue("numberFloors",
                    "create",
                    "Please enter a positive number !");
        }
    }
}
