package com.prajwal.springboottut.demo.DemoApp2.config;


import com.prajwal.springboottut.demo.DemoApp2.common.Coach;
import com.prajwal.springboottut.demo.DemoApp2.common.SpecialCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean
    public Coach specialCoach(){
        return new SpecialCoach();
    }
}
