package com.prajwal.springboottut.AOPdemo2.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {



//    @Before("execution( * com.prajwal.springboottut.AOPdemo2.dao.*.*(..))") // on any fucntion in package dao

    @Pointcut("execution( * com.prajwal.springboottut.AOPdemo2.dao.*.*(..))")
    private void forDaoPackage(){};


    @Pointcut("execution( * com.prajwal.springboottut.AOPdemo2.dao.*.get*(..))")
    private void forGet(){};

    @Pointcut("execution( * com.prajwal.springboottut.AOPdemo2.dao.*.set*(..))")
    private void forSet(){};


//    @Before("forDaoPackage()")
    @Pointcut("forDaoPackage() && !( forSet() || forGet() )")
    private  void exceptGS(){};

    @Before("exceptGS()")
    public void beforeAddAccountAdvice(){

        System.out.println("[ Executing @Before on addAccount() .... ]");
    }





}
