package com.example.carinsuranceapi3.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="user_info")
public class UserInfo extends BaseEntity{

    @Column(name="NAME")
    private String name;

    @Column(name="EMAIL")
    private String email;

    @Column(name="AGE")
    private String age;

    @Column(name="DRIVING_EXPERIENCE")
    private String drivingExperience;

    @Column(name="ACCIDENT_TYPE")
    private String accidentType;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="CAR_ID",referencedColumnName="ID")
    private Car car;
}
