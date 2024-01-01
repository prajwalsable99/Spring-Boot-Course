package com.prajwal.springbootut.MVCvalidationDemo.controller;

import com.prajwal.springbootut.MVCvalidationDemo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void InitStr(WebDataBinder webDataBinder){

        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);

    }

    @GetMapping("/home")
    public  String showForm(Model model){

        Customer customer=new Customer();
        model.addAttribute("customer",customer);
        return "home";
    }

    @PostMapping("/results")
    public  String showREs(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "home";
        }else {
            return "results";
        }



    }
}
