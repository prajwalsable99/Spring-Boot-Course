package com.example.springboottut.EmpApp.dao;

import com.example.springboottut.EmpApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//for custom path
//@RepositoryRestResource(path = "/members")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // no need to code !!yeah
}
