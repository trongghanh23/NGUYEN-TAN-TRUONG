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

}
