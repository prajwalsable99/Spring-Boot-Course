package com.prajwal.springboottut.AOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


//    @Before( "execution(public void addAccount())")  //macth on name

//    @Before("execution(public void com.prajwal.springboottut.AOPdemo.dao.AccountDAO.addAccount())") //on class


//    @Before( "execution(public void add*())") // on return type

//    @Before( "execution( * com.prajwal.springboottut.AOPdemo.dao.*.*())") // on any class in package

    //    @Before("execution(public void *(com.prajwal.springboottut.AOPdemo.Account))") // on parameter

    //    @Before("execution(public * add*(..))") // on any number of parameter
    @Before("execution(public * add*(com.prajwal.springboottut.AOPdemo.Account ,..))") // on any number of parameter

    public void beforeAddAccountAdvice(){

        System.out.println("[ Executing @Before on addAccount() .... ]");
    }


}
