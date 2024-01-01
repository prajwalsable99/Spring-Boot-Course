package com.prajwal.springboottut.demo.DemoApp2.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach {

    public FootballCoach(){
        System.out.println("construcotr==>"+this.getClass().getSimpleName());
    }
        @Override
        public String getDailyWorkout() {
            return "play pass pass in football";
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
