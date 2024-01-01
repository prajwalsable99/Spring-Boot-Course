package com.prajwal.springboottut.demo.DemoApp2.rest;

import com.prajwal.springboottut.demo.DemoApp2.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
        private Coach mycoach ;


//      constructor injection
        @Autowired

    public DemoController( @Qualifier("specialCoach") Coach coach){

            System.out.println("construcotr==>"+this.getClass().getSimpleName());

            mycoach=coach;

    }

    //      method injection
//    @Autowired
//    public  void setCoach(Coach coach){
//            mycoach=coach;
//    }

    @GetMapping("/getDailyWorkout")
    public String getWorkout(){
        return mycoach.getDailyWorkout();
    }

    @GetMapping("/")
    public String getHome(){
        return "Coachify";
    }
//
//    @GetMapping("/check")
//    public String Check(){
//        return "is equal "+(mycoach==mycoach2);
//    }

}
