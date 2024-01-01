package com.example.springboottut.EmpApp.controller;


import com.example.springboottut.EmpApp.entity.Employee;
import com.example.springboottut.EmpApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theemployeeService){
        employeeService=theemployeeService;
    }

    @GetMapping("/list")
    public  String listEmployees (Model model){

        List<Employee> employees=employeeService.findAll();

        model.addAttribute("employees",employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showAddForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
//        System.out.println(employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String addNewEmp(@ModelAttribute("employee") Employee employee ){

            employeeService.save(employee);

        //redirect to prevent duplicates
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showUpdateForm(@RequestParam("empId") int id,Model model){
        Employee employee=employeeService.findById(id);
        model.addAttribute("employee",employee);
//        System.out.println(employee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForDelete")
    public String justDelete(@RequestParam("empId") int id,Model model){
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }

}
