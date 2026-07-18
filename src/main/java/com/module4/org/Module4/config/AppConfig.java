package com.module4.org.Module4.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class AppConfig {

    @Bean
    ModelMapper getModelMapper(){
     return new ModelMapper();
    }

}
