package com.prajwal.springbootut.DemoApp.dao;

import com.prajwal.springbootut.DemoApp.entity.Course;
import com.prajwal.springbootut.DemoApp.entity.Instructor;
import com.prajwal.springbootut.DemoApp.entity.InstructorDetail;
import com.prajwal.springbootut.DemoApp.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);

    //bi

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    //courses

    List<Course> findCoursesByInstructorId(int id);

    void updateInsructor(Instructor instructor);

    Course findCourseById(int cid);

    void updateCourse(Course course);

void  deleteCourseById(int cid);

void save(Course course);

Course findCourseAndReviewsByCourseId(int id);

//------------

    Course findCourseAndStudentByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);

    void update(Student student);
    void deleteStudentById(int id);



}
