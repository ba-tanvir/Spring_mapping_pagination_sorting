package com.example.carinsuranceapi3.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="car")
@EqualsAndHashCode(callSuper=true)
public class Car extends BaseEntity{

    @Column(name="CAR_NAME")
    private String carName;

    @Column(name="BRAND_NAME")
    private String brandName;

    @Column(name="MODEL")
    private String model;

    @Column(name="ENGINE")
    private String engine;

    @Column(name="ENGINE_SIZE")
    private String engineSize;

    @Column(name="CAR_TYPE")
    private String carType;

    @Column(name="PRICE")
    private String price;

    @OneToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name="INSURANCE_ID",referencedColumnName="ID")
    private Insurance insurance;

}




