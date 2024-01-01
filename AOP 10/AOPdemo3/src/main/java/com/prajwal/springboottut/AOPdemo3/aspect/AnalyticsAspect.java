package com.prajwal.springboottut.AOPdemo3.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Order(3)
@Component
public class AnalyticsAspect {




//    @Pointcut("execution( * com.prajwal.springboottut.AOPdemo3.dao.*.*(..))")
//    private void forDaoPackage(){};


    @Before("com.prajwal.springboottut.AOPdemo3.aspect.PointCutExp.forDaoPackage()")

    public void beforeAnalyticsAdvice(){

        System.out.println("[ Executing AnalyticsAdvice @Before on addAccount() .... ]");
    }




}
