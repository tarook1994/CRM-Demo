package com.example.CRMdemo.Aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.example.CRMdemo.DAO.CustomerDAOImpl.*(..))")
    public void anyDAOMethod(){

    }

    @Before("anyDAOMethod()")
    public void logBeforeDAO(){
        System.out.println("Logging");
    }


    @After("anyDAOMethod()")
    public void logAfterDAO(){
        System.out.println("After DAO");
    }

    @Around("anyDAOMethod()")
    public Object timeCalculation(ProceedingJoinPoint proceedingJoinPoint){
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
             result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin + " Milliseconds" + result);
        return result;
    }


}
