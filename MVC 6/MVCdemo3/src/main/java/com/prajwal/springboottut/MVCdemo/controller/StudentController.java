package com.prajwal.springboottut.MVCdemo.controller;

import com.prajwal.springboottut.MVCdemo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;
import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> Countries;
    @Value("${genders}")
    private List<String> Genders;

    @Value("${ops}")
    private List<String> Ops;



    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public  String showForm(Model model){

        model.addAttribute("countries",Countries);
        model.addAttribute("genders",Genders);
        model.addAttribute("ops",Ops);

        //create student obj
        Student student=new Student();
        //add it


        model.addAttribute("student",student);

        return "studentform";
    }


    @RequestMapping(value = "/results",method = RequestMethod.POST)
    public  String showResults( @ModelAttribute("student") Student student){

        System.out.println(student);




        return "result";
    }

}
