package com.prajwal.springboottut.MVCdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class DemoController {

    @RequestMapping("/home")
    public String showHome(Model theModel){

        theModel.addAttribute("dateVar",new Date());
        return "home";
    }

//method 1
    @RequestMapping("/results")
    public String showRes( ){




        return "result";
    }


    //method 2
    @RequestMapping("/results2")
    public String showRes2(HttpServletRequest httpServletRequest,Model model){

    String fname= httpServletRequest.getParameter("fname");

    fname=fname.toUpperCase();

    model.addAttribute("mName",fname);




        return "result";
    }

    //method 3
    @RequestMapping("/results3")
    public String showRes3(@RequestParam("fname") String rName, Model model) {

        rName=rName.toUpperCase();
        model.addAttribute("mName",rName);


        return  "result";

    }



}
