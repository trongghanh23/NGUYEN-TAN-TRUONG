package com.code_gym.castudy.model.facility;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "rentType")
public class RentType {
    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "rentType")
    private List<Facility>facilityList;

    public RentType() {
    }

    public RentType(Integer id, String name, List<Facility> facilityList) {
        this.id = id;
        this.name = name;
        this.facilityList = facilityList;
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

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
