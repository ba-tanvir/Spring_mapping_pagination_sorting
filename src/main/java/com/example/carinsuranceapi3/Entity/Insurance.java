package com.example.carinsuranceapi3.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="insurance")
@EqualsAndHashCode(callSuper=true)
public class Insurance extends BaseEntity {

    @Column(name="INSURANCE_NAME")
    private String insuranceName;

    @Column(name="INSURANCE_COVERAGE")
    private String insuranceCoverage;

    @Column(name="INSURANCE_VEHICLE_TYPE")
    private String insuranceVehicleType;

    @Column(name="PRICE")
    private String price;
}



