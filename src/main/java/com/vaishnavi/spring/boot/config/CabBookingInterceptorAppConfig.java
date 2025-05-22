package com.vaishnavi.spring.boot.config;

import com.vaishnavi.spring.boot.interceptor.CabBookingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CabBookingInterceptorAppConfig implements WebMvcConfigurer {

    @Autowired
    private CabBookingInterceptor cabBookingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(cabBookingInterceptor);
    }
}


