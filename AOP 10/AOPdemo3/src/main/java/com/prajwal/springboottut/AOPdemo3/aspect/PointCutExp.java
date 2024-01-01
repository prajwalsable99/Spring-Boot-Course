package com.prajwal.springboottut.AOPdemo3.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutExp {
    @Pointcut("execution( * com.prajwal.springboottut.AOPdemo3.dao.*.*(..))")
    public void forDaoPackage(){};
}
