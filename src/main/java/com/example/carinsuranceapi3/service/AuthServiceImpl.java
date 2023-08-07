package com.example.carinsuranceapi3.service;

import com.example.carinsuranceapi3.Entity.Car;
import com.example.carinsuranceapi3.Entity.UserInfo;
import com.example.carinsuranceapi3.dto.UerInfoBean;
import com.example.carinsuranceapi3.dto.UserCreateBean;
import com.example.carinsuranceapi3.repository.CarRepository;
import com.example.carinsuranceapi3.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;


@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{


    @Autowired
    private UserInfoRepository userInfoRepository;

    private CarRepository carRepository;

    private ModelMapper modelMapper;

    @Override
    public UerInfoBean createdUser(UerInfoBean signupRequest) {
        return null;
    }

    @Override
    public UerInfoBean createdUser(UserCreateBean signupRequest){
        UserInfo user= new UserInfo();
        user.setId(signupRequest.getId());
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setAge(signupRequest.getAge());
        user.setAccidentType(signupRequest.getAccidentType());
        user.setDrivingExperience(signupRequest.getDrivingExperience());
        Car userCar=carRepository.findById(signupRequest.getCarId()).orElseThrow(()->new RuntimeException("No car found"));
        user.setCar(userCar);
        userInfoRepository.save(user);
        return modelMapper.map(user,UerInfoBean.class);

    }


}

