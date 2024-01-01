package com.prajwal.springboottut.AOPdemo9.aspect;

import com.prajwal.springboottut.AOPdemo9.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
//@Order(2)
@Component
public class MyDemoLoggingAspect {

        @Around("com.prajwal.springboottut.AOPdemo9.aspect.PointCutExp.forFortune()")
    public Object AroundAdviceHandle(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("[ Executing  Around ((1,before))  Advice  on " +proceedingJoinPoint.getSignature().toString() +" ]" );

        long begin=System.currentTimeMillis();

        //calling the duncition on which advice will happen

        Object result=null;
        try {

            result=proceedingJoinPoint.proceed();
        }catch (Exception e){
            System.out.println(e.getMessage());
            result="HANDLED RES : Expect heavy traffic";
        }

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("[ Executing  Around ((2,after))  Advice  on " +proceedingJoinPoint.getSignature().toString() +" ]" );


        long end=System.currentTimeMillis();

        long dur=end-begin;
        System.out.println("Duration :"+dur);

        return result;

    }





//    @Around("com.prajwal.springboottut.AOPdemo9.aspect.PointCutExp.forFortune()")
//    public Object AroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
//
//        System.out.println("------------------------------------------------------------------------------------------");
//        System.out.println("[ Executing  Around ((1,before))  Advice  on " +proceedingJoinPoint.getSignature().toString() +" ]" );
//
//        long begin=System.currentTimeMillis();
//
//        //calling the duncition on which advice will happen
//
//        Object result=proceedingJoinPoint.proceed();
//
//        System.out.println("------------------------------------------------------------------------------------------");
//        System.out.println("[ Executing  Around ((2,after))  Advice  on " +proceedingJoinPoint.getSignature().toString() +" ]" );
//
//
//        long end=System.currentTimeMillis();
//
//        long dur=end-begin;
//        System.out.println("Duration :"+dur);
//
//        return result;
//
//    }









    @After("com.prajwal.springboottut.AOPdemo9.aspect.PointCutExp.forFind()")
    public void AfterAdvice(JoinPoint joinPoint){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("[ Executing @After  Advice  on " +joinPoint.getSignature().toString() +" ]" );


        System.out.println("[ Ending @After  Advice  on " +joinPoint.getSignature().toString()+" ]");
        System.out.println("------------------------------------------------------------------------------------------");


    }

    @AfterThrowing(pointcut = "com.prajwal.springboottut.AOPdemo9.aspect.PointCutExp.forFind()" , throwing= "exec")
    public void AfterThrowingAdvice(JoinPoint joinPoint, Throwable exec) {

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("[ Executing After throwing Advice  on " +joinPoint.getSignature().toString() +" ]" );

        System.out.println( "In afterthrowing advice :"+exec.toString());

        System.out.println("[ Ending After throwing Advice  on " +joinPoint.getSignature().toString()+" ]");
        System.out.println("------------------------------------------------------------------------------------------");

    }


    @AfterReturning( pointcut = "com.prajwal.springboottut.AOPdemo9.aspect.PointCutExp.forFind()" ,returning = "result")
    public void AfterReturningAddAccountAdvice(JoinPoint joinPoint, List<Account> result){
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






//    @Before("com.prajwal.springboottut.AOPdemo9.aspect.PointCutExp.forDaoPackage()")
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
