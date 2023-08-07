package com.example.carinsuranceapi3.resource;


import com.example.carinsuranceapi3.Entity.Car;
import com.example.carinsuranceapi3.Entity.UserInfo;
import com.example.carinsuranceapi3.dto.UerInfoBean;
import com.example.carinsuranceapi3.dto.UserCreateBean;
import com.example.carinsuranceapi3.repository.CarRepository;
import com.example.carinsuranceapi3.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserResource {

    private final UserService userService;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @GetMapping("get_all")
    public ResponseEntity<List<UerInfoBean>> get_all(){
        return ResponseEntity.ok().body(userService.get_all());
    }

    @GetMapping("get_all_sort/{fieldName}")
    public ResponseEntity<List<UerInfoBean>> get_all_sort(@PathVariable("fieldName") String fieldName){
        return ResponseEntity.ok().body(userService.get_all_sorting(fieldName));
    }

    @GetMapping("pagination/{offset}/{pageSize}")
    public ResponseEntity<List<UerInfoBean>> get_Pagination(@PathVariable("offset") int offset, @PathVariable("pageSize") int pageSize ){
        return ResponseEntity.ok().body(userService.get_pagination(offset,pageSize));
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody UserCreateBean userCreate){
        Car car=carRepository.findById(userCreate.getCarId())
                .orElseThrow(()->new RuntimeException("No Car ID found"));
        UserInfo newUser=this.modelMapper.map(userCreate, UserInfo.class);
        newUser.setCar(car);
        System.out.println(newUser);
        UerInfoBean user=userService.create(newUser);
        return ResponseEntity.ok(user);
    }
}
