package com.example.springboottut.EmpApp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class DemoLoggingAspect {

    //logger
    private final Logger logger=Logger.getLogger(getClass().getName());

    //pointcut
    @Pointcut("execution(* com.example.springboottut.EmpApp.controller.*.*(..) )")
    private void forController(){}
    @Pointcut("execution(* com.example.springboottut.EmpApp.service.*.*(..) )")
    private void forService(){}
    @Pointcut("execution(* com.example.springboottut.EmpApp.dao.*.*(..) )")
    private void forDAO(){}
    @Pointcut("forController() || forService() || forDAO()")
    private void forAppFlow() {}

//  aops
    @Before("forAppFlow()")
    public void runBefore(JoinPoint joinPoint){

        String method=joinPoint.getSignature().toShortString();

        logger.info("===> in @Before : calling "+ method);

        Object[] args=joinPoint.getArgs();

        for(Object o : args){
            logger.info("args==> "+o);
        }
    }

    @AfterReturning( pointcut = "forAppFlow()",returning = "result")
    public void runAfterReturning(JoinPoint joinPoint,Object result){
        String method=joinPoint.getSignature().toShortString();

        logger.info("===> in @AfterReturning : calling "+ method);

        System.out.println("returned result==>"+ result);



    }


}
