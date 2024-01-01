package com.example.springboottut.EmpApp.service;

import com.example.springboottut.EmpApp.dao.EmployeeRepository;
import com.example.springboottut.EmpApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Autowired
    public  EmployeeServiceImpl(EmployeeRepository e){

        employeeRepository=e;
    }
    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);

        if(result.isEmpty()){
            throw  new RuntimeException("Emp not found");
        }
        return result.get();
    }

    @Override
//    @Transactional
    public Employee save(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
//    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
