package com.example.springboottut.EmpApp.dao;

import com.example.springboottut.EmpApp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int id);

    Employee save(Employee e);

    void deleteById(int id);

}
