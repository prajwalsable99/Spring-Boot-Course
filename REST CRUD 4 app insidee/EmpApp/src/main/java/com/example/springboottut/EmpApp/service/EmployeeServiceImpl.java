package com.example.springboottut.EmpApp.service;

import com.example.springboottut.EmpApp.dao.EmployeeDAO;
import com.example.springboottut.EmpApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;
    @Autowired
    public  EmployeeServiceImpl(EmployeeDAO e){
        employeeDAO=e;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee e) {
        return employeeDAO.save(e);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
