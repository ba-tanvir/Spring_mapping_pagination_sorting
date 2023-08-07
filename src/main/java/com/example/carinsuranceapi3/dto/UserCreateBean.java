package com.example.carinsuranceapi3.dto;

import com.example.carinsuranceapi3.Entity.Car;
import lombok.Data;


@Data
public class UserCreateBean {
    private String id;
    private String name;
    private String email;
    private String age;
    private String drivingExperience;
    private String accidentType;
    private String carId;
}
