package com.example.carinsuranceapi3.resource;


import com.example.carinsuranceapi3.Entity.Car;
import com.example.carinsuranceapi3.Entity.Insurance;
import com.example.carinsuranceapi3.dto.CarBean;
import com.example.carinsuranceapi3.dto.CarCreateBean;
import com.example.carinsuranceapi3.repository.CarRepository;
import com.example.carinsuranceapi3.repository.InsuranceRepository;
import com.example.carinsuranceapi3.service.CarService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("car")
@AllArgsConstructor
public class CarResource {
    private final CarService carService;
    private final InsuranceRepository insuranceRepository;

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @GetMapping("get_all")
    public ResponseEntity<List<CarBean>> get_all()
    {
        return ResponseEntity.ok().body(carService.get_all());
    }

    @GetMapping("get_all_sort/{fieldName}")
    public ResponseEntity<List<CarBean>> get_all_sorted(@PathVariable("fieldName") String fieldName ){
        return ResponseEntity.ok().body(carService.get_all_sorting(fieldName));
    }

    @GetMapping("pagination/{offset}/{pageSize}")
    public ResponseEntity<List<CarBean>> get_paginated(@PathVariable("offset") int offset,@PathVariable("pageSize") int pageSize){
        return ResponseEntity.ok().body(carService.get_pagination(offset,pageSize));
    }

    @PostMapping("create")
    public ResponseEntity<?> create_car(@RequestBody CarCreateBean createBean) {
        Insurance insurance = insuranceRepository.findById(createBean.getInsuranceId()).orElseThrow(() -> new RuntimeException("No Insurance found"));
        Car car = modelMapper.map(createBean, Car.class);
        car.setInsurance(insurance);
        CarBean createdCar = carService.create(car);
        return ResponseEntity.ok(createdCar);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update_car(@PathVariable("id") String id, @RequestBody CarCreateBean createBean){
       Car car=carRepository.findById(id).orElseThrow(()->new RuntimeException("Car is not Found"));
       Insurance insurance=insuranceRepository.findById(createBean.getInsuranceId()).orElseThrow(()->new RuntimeException("No insurance found"));
        Car carUpdate=modelMapper.map(createBean,Car.class);
        carUpdate.setInsurance(insurance);
        CarBean updated_car=carService.update(carUpdate);
        return ResponseEntity.ok(updated_car);
    }


}
