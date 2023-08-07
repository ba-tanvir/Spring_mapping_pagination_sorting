package com.example.carinsuranceapi3.dto;

import lombok.Data;

@Data
public class CarCreateBean {
    private String id;
    private String carName;
    private String brandName;
    private String model;
    private String engine;
    private String engineSize;
    private String carType;
    private String price;
    private String insuranceId;
}
