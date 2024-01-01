package com.example.springboottut.DemoApp3.dao;

import com.example.springboottut.DemoApp3.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student stud);

   Student findById(Integer id);


   List<Student> findAll();
   List<Student> findBylastName(String lname);

   void update(Student student);
   void delete(Integer id);

   int deleteAll();

}
