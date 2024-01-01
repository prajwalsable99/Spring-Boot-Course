package com.prajwal.springbootut.DemoApp.dao;

import com.prajwal.springbootut.DemoApp.entity.Course;
import com.prajwal.springbootut.DemoApp.entity.Instructor;
import com.prajwal.springbootut.DemoApp.entity.InstructorDetail;
import com.prajwal.springbootut.DemoApp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager theentityManager){
        entityManager=theentityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {

        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        Instructor instructor=entityManager.find(Instructor.class,id);
        return instructor;
    }

    @Override @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor=entityManager.find(Instructor.class,id);

        /////////////////////////later changes
        List<Course> courses=instructor.getCourses();

        for( Course course : courses){
            course.setInstructor(null);
        }
       ///////////////////////
        entityManager.remove(instructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class,id);
        entityManager.remove(instructorDetail);

    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id=:data",Course.class);
        query.setParameter("data",id);
        List<Course> courses=query.getResultList();
        return courses;
    }

    @Override
    @Transactional
    public void updateInsructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int cid) {
        return entityManager.find(Course.class,cid);
    }

    @Override @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override @Transactional
    public void deleteCourseById(int cid) {
        Course c=entityManager.find(Course.class,cid);
        entityManager.remove(c);

    }

    @Override @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        TypedQuery<Course> query= entityManager.createQuery(" select c from Course c JOIN FETCH c.reviews where c.id=:data",Course.class);
        query.setParameter("data",id);

        Course course=query.getSingleResult();
        return  course;


    }

    @Override
    public Course findCourseAndStudentByCourseId(int cid) {

        TypedQuery<Course> query= entityManager.createQuery(" select c from Course c JOIN FETCH c.students where c.id=:data",Course.class);
        query.setParameter("data",cid);

        Course course=query.getSingleResult();
        return  course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {


        TypedQuery<Student> query= entityManager.createQuery(" select s from Student s JOIN FETCH s.courses where s.id=:data",Student.class);
        query.setParameter("data",id);

        Student student;
        student = query.getSingleResult();
        return  student;
    }

    @Override @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override @Transactional
    public void deleteStudentById(int id) {

        Student student= entityManager.find(Student.class,id);

        entityManager.remove(student);
    }


}
