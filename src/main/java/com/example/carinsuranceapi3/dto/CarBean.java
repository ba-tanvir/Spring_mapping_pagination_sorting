package com.example.carinsuranceapi3.dto;

import com.example.carinsuranceapi3.Entity.Insurance;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class CarBean implements IRequestBodyDTO{

    private String carName;
    private String brandName;
    private String model;
    private String engine;
    private String engineSize;
    private String carType;
    private String price;
    private Insurance insurance;
}

//private InsuranceBean insurance -- holds the object not just id



