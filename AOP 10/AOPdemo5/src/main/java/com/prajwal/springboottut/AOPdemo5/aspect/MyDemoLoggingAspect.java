package com.prajwal.springboottut.AOPdemo5.aspect;

import com.prajwal.springboottut.AOPdemo5.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
//@Order(2)
@Component
public class MyDemoLoggingAspect {


    @AfterReturning( pointcut = "com.prajwal.springboottut.AOPdemo5.aspect.PointCutExp.forFind()" ,returning = "result")
    public void beforeAddAccountAdvice(JoinPoint joinPoint, List<Account> result){
        System.out.println("------------------------------------------------------------------------------------------");

        System.out.println("[ Executing After returning Advice  on " +joinPoint.getSignature().toString() +" ]" );

        System.out.println("Modifying data (capitalizing)");
        String name,level;
        for (Account account:result){
            name=account.getName().toUpperCase();
            level=account.getLevel().toUpperCase();

            account.setName(name);
            account.setLevel(level);

        }


        System.out.println("[ Ending After returning Advice  on " +joinPoint.getSignature().toString()+" ]");
        System.out.println("------------------------------------------------------------------------------------------");
    }






//    @Before("com.prajwal.springboottut.AOPdemo5.aspect.PointCutExp.forDaoPackage()")
//
//    public void beforeAddAccountAdvice(JoinPoint joinPoint){
//
//        System.out.println("[ Executing Sample Advice @Before on matched fun().... ]");
//
//        //fun() name
//        System.out.println("------------------Method Details---------------------------");
//        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
//        System.out.println("[Mehod signature==> "+methodSignature+" ]");
//
//        //args
//
//        Object [] args=joinPoint.getArgs();
//
//        if(args.length==0) System.out.println("[No args to method]");
//
//        for (Object o:args){
//
//            if(o instanceof Account){
//                Account account=(Account) o;
//                System.out.println("arg aname : "+account.getName());
//                System.out.println("arg alevel : "+account.getLevel());
//            }else {
//                System.out.println("arg : "+ o);
//            }
//        }
//
//    }






}
