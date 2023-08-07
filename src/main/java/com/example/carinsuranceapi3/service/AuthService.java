package com.example.carinsuranceapi3.service;

import com.example.carinsuranceapi3.dto.UerInfoBean;
import com.example.carinsuranceapi3.dto.UserCreateBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;




public interface AuthService {
    UerInfoBean createdUser(UerInfoBean signupRequest);


    UerInfoBean createdUser (UserCreateBean signupRequest);
}
