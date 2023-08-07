package com.example.carinsuranceapi3.resource;


import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")

public class SecurityResource {

    @GetMapping("start")
    public String start(){
        return ResponseEntity.ok().body("Starting spring security").getBody();
    }

    @GetMapping("end")
    public String end(){
        return ResponseEntity.ok().body("Ending Spring JWT Security").getBody();
    }

}
