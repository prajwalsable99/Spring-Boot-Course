package com.prajwal.springboottut.demo.DemoApp2.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
@Primary
//@Lazy
public class WarmupCoach implements Coach {


    public WarmupCoach(){
        System.out.println("construcotr==>"+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "do warmup";
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
