package com.code_gym.castudy.model.facility;

import com.code_gym.castudy.model.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    private String standardRoom;
    private String description;
    private Double poolArea;
    private Integer numberFloors;
    private String facilityFree;
    @JoinColumn(name = "FacilityType",referencedColumnName = "id")
    @ManyToOne
    private FacilityType facilityType;

    @JoinColumn(name = "rentType",referencedColumnName = "id")
    @ManyToOne
    private RentType rentType;

    @OneToMany(mappedBy = "facility")
    private List<Contract>contractList;

}
