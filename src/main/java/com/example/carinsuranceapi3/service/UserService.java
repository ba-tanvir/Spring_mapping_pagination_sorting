package com.example.carinsuranceapi3.service;

import com.example.carinsuranceapi3.Entity.UserInfo;
import com.example.carinsuranceapi3.dto.UerInfoBean;
import com.example.carinsuranceapi3.repository.BaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService extends BaseService<UserInfo, UerInfoBean>{
    public UserService(BaseRepository<UserInfo> repository, ModelMapper modelMapper){
        super(repository,modelMapper);
    }
}
