package com.example.carinsuranceapi3.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.apache.tomcat.util.net.AbstractEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Log
@Component
public class ApiRequestInterceptor implements HandlerInterceptor {

    @Override
    @SneakyThrows
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler){
        String uri=request.getRequestURI();
        return uri.contains("car") || uri.contains("insurance") || uri.contains("user")
                || uri.contains("security") || uri.contains("register")
                || uri.contains("authentication");
    }

}
