package com.example.carinsuranceapi3.service;

import com.example.carinsuranceapi3.Entity.Insurance;
import com.example.carinsuranceapi3.dto.InsuranceBean;
import com.example.carinsuranceapi3.repository.BaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service("insuranceService")
public class InsuranceService extends BaseService<Insurance, InsuranceBean>{
    public InsuranceService(BaseRepository<Insurance> repository, ModelMapper modelMapper){
        super(repository,modelMapper);
    }
}
