package com.prajwal.springboottut.demo.demoApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${homepage.data1}")
    private String fname;

    @Value("${homepage.data2}")
    private String sname;


    @GetMapping("/")
    public String sayHello(){
        return fname +" " + sname;
    }

    @GetMapping("/contact")
    public String sayContact(){
        return "Contacts !";
    }

    @GetMapping("/pricing")
    public String sayPrice(){
        return "pricing";
    }
}
