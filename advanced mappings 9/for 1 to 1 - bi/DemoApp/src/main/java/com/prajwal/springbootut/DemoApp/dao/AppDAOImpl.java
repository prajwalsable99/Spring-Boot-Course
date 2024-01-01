package com.prajwal.springbootut.DemoApp.dao;

import com.prajwal.springbootut.DemoApp.entity.Instructor;
import com.prajwal.springbootut.DemoApp.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
