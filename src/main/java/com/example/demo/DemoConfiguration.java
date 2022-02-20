package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.*;
/**
 * DemoConfiguration
 */
@Configuration
public class DemoConfiguration {

    @Bean
    public ModelMapper modelMapper(){
return new ModelMapper();
    }
    
}