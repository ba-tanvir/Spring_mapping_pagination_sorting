package com.example.carinsuranceapi3.dto;

import com.example.carinsuranceapi3.Entity.Car;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class InsuranceBean implements IRequestBodyDTO{

    private String insuranceName;
    private String insuranceCoverage;
    private String insuranceVehicleType;
    private String price;
}

