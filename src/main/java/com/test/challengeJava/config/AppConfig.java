package com.test.challengeJava.config;

import com.test.challengeJava.exception.EmployeeResponseErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new EmployeeResponseErrorHandler());
        return restTemplate;
    }
}
