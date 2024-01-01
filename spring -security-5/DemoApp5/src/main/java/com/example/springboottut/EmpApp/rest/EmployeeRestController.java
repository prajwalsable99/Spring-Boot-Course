package com.example.springboottut.EmpApp.rest;

import com.example.springboottut.EmpApp.entity.Employee;
import com.example.springboottut.EmpApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public  EmployeeRestController(EmployeeService e){
        employeeService=e;
    }

    @GetMapping("/employees")
    public List<Employee> getAll(){

        return employeeService.findAll();
    }

    @GetMapping("employees/{id}")
    public Employee getEmp(@PathVariable int id){
        Employee employee=employeeService.findById(id);

        if(employee==null){
            throw   new RuntimeException("employee not found");
        }
        return employee;

    }

    @PostMapping("/employees")
    public  Employee createEmp(@RequestBody Employee e){

        e.setId(0);
        return employeeService.save(e);
    }

    @PutMapping("/employees")
    public  Employee updateEmp( @RequestBody  Employee e){
        return employeeService.save(e);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmp(@PathVariable int id){
        Employee employee=employeeService.findById(id);
        if(employee==null){
            throw   new RuntimeException("employee not found");
        }
        employeeService.deleteById(id);
        return "Emloyee deleted==>" + id;

    }



}
