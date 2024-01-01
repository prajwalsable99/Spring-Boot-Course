package com.prajwal.springboottut.demo.DemoApp2.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


public class SpecialCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "I am special Coach";
    }
    public SpecialCoach(){
        System.out.println("construcotr==>"+this.getClass().getSimpleName());
    }





}
