package com.prajwal.springboottut.demo.DemoApp2.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("construcotr==>"+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Bat in nets for 1 hour";
    }
    @PostConstruct
    public void doStart(){
        System.out.println("bean init==>"+this.getClass().getSimpleName());
    }

    @PreDestroy
    public void doEnd(){
        System.out.println("bean destroy==>"+this.getClass().getSimpleName());
    }
}
