package com.example.carinsuranceapi3.service;

import com.example.carinsuranceapi3.Entity.Car;
import com.example.carinsuranceapi3.dto.CarBean;
import com.example.carinsuranceapi3.repository.BaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service("carService")
public class CarService extends BaseService<Car, CarBean>{
    public CarService(BaseRepository<Car> repository, ModelMapper modelMapper){
        super(repository,modelMapper);
    }
}
