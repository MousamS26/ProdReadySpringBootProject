package com.module4.org.Module4.config;

import com.module4.org.Module4.auth.AuditorAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.ui.ModelMap;

//Attach the AuditorAware reference to JpaAuditing by giving the Auditor's bean name
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImpl")
@Configuration
public class AppConfig {

    @Bean
    ModelMapper getModelMapper(){
     return new ModelMapper();
    }

    @Bean
    AuditorAware<String> getAuditorAwareImpl()
    {
        return new AuditorAwareImpl();
    }

}
