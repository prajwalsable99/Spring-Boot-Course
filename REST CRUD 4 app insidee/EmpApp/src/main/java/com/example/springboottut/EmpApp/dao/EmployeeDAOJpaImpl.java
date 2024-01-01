package com.example.springboottut.EmpApp.dao;

import com.example.springboottut.EmpApp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager e){
        entityManager=e;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> q= entityManager.createQuery("from Employee",Employee.class);

        List<Employee> employees;
        employees = q.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {

        Employee e= entityManager.find(Employee.class,id);
        return  e;
    }

    @Override
    public Employee save(Employee e) {
        return entityManager.merge(e);
    }

    @Override
    public void deleteById(int id) {
        Employee e= entityManager.find(Employee.class,id);
        entityManager.remove(e);

    }
}
