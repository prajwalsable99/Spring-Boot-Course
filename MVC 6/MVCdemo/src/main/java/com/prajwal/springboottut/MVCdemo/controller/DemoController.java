package com.prajwal.springboottut.MVCdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class DemoController {

    @GetMapping("/home")
    public String showHome(Model theModel){

        theModel.addAttribute("dateVar",new Date());
        return "home";
    }

}
