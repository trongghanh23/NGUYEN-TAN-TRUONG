package com.code_gym.castudy.dto;

import com.code_gym.castudy.common.CheckRegexFacility;
import com.code_gym.castudy.model.facility.FacilityType;
import com.code_gym.castudy.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class FacilityDto implements Validator {
    private Integer id;
    private String name;

    private String area;

    private String cost;

    private String maxPeople;

    @NotBlank(message = "please enter")
    private String standardRoom;

    @NotBlank(message = "please enter")
    private String description;

    private String poolArea;

    private String numberFloors;

    private String facilityFree;

    private RentType rentType;
    private FacilityType  facilityType;

    public FacilityDto() {
    }

    public FacilityDto(Integer id, String name, String area, String cost, String maxPeople, String standardRoom, String description, String poolArea, String numberFloors, String facilityFree, RentType rentType, FacilityType facilityType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(String numberFloors) {
        this.numberFloors = numberFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto= (FacilityDto) target;
        CheckRegexFacility.checkName(facilityDto,errors);
        CheckRegexFacility.checkCost(facilityDto,errors);
        CheckRegexFacility.checkArea(facilityDto,errors);
        CheckRegexFacility.checkMaxPeople(facilityDto,errors);
        CheckRegexFacility. checkPoolArea(facilityDto,errors);
        CheckRegexFacility. checkFloors(facilityDto,errors);

    }
}
