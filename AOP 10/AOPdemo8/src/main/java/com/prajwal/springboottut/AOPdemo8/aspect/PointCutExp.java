package com.prajwal.springboottut.AOPdemo8.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutExp {

    @Pointcut("execution( * com.prajwal.springboottut.AOPdemo8.service.*.*(..))")
    public void forFortune(){};

    @Pointcut("execution( * com.prajwal.springboottut.AOPdemo8.dao.AccountDAO.find*(..))")
    public void forDaoPackage(){};

    @Pointcut("execution( * com.prajwal.springboottut.AOPdemo8.dao.*.*(..))")
    public void forFind(){};


}
