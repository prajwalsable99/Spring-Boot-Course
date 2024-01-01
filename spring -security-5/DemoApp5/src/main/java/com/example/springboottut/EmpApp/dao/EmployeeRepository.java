package com.example.springboottut.EmpApp.dao;

import com.example.springboottut.EmpApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // no need to code !!yeah
}
