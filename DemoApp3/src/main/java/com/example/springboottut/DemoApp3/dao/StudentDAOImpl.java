package com.example.springboottut.DemoApp3.dao;

import com.example.springboottut.DemoApp3.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Student stud) {

        entityManager.persist(stud);
    }


    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> q=entityManager.createQuery("FROM Student ",Student.class);

        return q.getResultList();
    }

    @Override
    public List<Student> findBylastName(String lname) {
        TypedQuery<Student> q=entityManager.createQuery("FROM Student where lastName=:xData ",Student.class);
        q.setParameter("xData",lname);

        return q.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {


        entityManager.merge(student);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
       Student s=  entityManager.find(Student.class,id);
       entityManager.remove(s);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int x= entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return x;
    }
}
