package com.prajwal.springboottut.AOPdemo5.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutExp {
    @Pointcut("execution( * com.prajwal.springboottut.AOPdemo5.dao.AccountDAO.find*(..))")
    public void forDaoPackage(){};

    @Pointcut("execution( * com.prajwal.springboottut.AOPdemo5.dao.*.*(..))")
    public void forFind(){};


}
