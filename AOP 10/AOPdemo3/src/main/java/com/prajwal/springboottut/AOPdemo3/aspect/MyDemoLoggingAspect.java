package com.prajwal.springboottut.AOPdemo3.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect {


//    @Pointcut("execution( * com.prajwal.springboottut.AOPdemo3.dao.*.*(..))")
//    private void forDaoPackage(){};

    @Before("com.prajwal.springboottut.AOPdemo3.aspect.PointCutExp.forDaoPackage()")

    public void beforeAddAccountAdvice(){

        System.out.println("[ Executing Sample Advice @Before on addAccount() .... ]");
    }






}
