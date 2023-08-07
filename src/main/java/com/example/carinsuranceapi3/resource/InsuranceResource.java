package com.example.carinsuranceapi3.resource;


import com.example.carinsuranceapi3.Entity.Insurance;
import com.example.carinsuranceapi3.dto.CarBean;
import com.example.carinsuranceapi3.dto.InsuranceBean;
import com.example.carinsuranceapi3.service.InsuranceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("insurance")
@AllArgsConstructor
public class InsuranceResource {

    private final InsuranceService insuranceService;

    @GetMapping("get_all")
    public ResponseEntity<List<InsuranceBean>> get_all(){
        return ResponseEntity.ok().body(insuranceService.get_all());
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody Insurance new_item) {
        return ResponseEntity.ok().body(insuranceService.create(new_item));
    }
}
