package com.example.springboottut.EmpApp.service;

import com.example.springboottut.EmpApp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee e);

    void deleteById(int id);
}
