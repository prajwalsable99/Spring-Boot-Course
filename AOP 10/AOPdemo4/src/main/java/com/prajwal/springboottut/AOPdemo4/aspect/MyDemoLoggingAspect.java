package com.prajwal.springboottut.AOPdemo4.aspect;

import com.prajwal.springboottut.AOPdemo4.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect {



    @Before("com.prajwal.springboottut.AOPdemo4.aspect.PointCutExp.forDaoPackage()")

    public void beforeAddAccountAdvice(JoinPoint joinPoint){

        System.out.println("[ Executing Sample Advice @Before on addAccount() .... ]");

        //fun() name
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        System.out.println("[Mehod signature==> "+methodSignature+" ]");

        //args

        Object [] args=joinPoint.getArgs();

        for (Object o:args){

            if(o instanceof Account){
                Account account=(Account) o;
                System.out.println("arg aname : "+account.getName());
                System.out.println("arg alevel : "+account.getLevel());
            }else {
                System.out.println("arg : "+ o);
            }
        }

    }






}
