package com.code_gym.castudy.model.facility;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "FacilityType")
public class FacilityType {
    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "facilityType")
    private List<Facility>facilityList;

}
