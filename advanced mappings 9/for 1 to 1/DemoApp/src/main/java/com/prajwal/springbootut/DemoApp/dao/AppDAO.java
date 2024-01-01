package com.prajwal.springbootut.DemoApp.dao;

import com.prajwal.springbootut.DemoApp.entity.Instructor;
import org.springframework.stereotype.Repository;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
