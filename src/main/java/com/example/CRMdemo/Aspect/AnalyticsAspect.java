package com.example.CRMdemo.Aspect;


import com.example.CRMdemo.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Order(3)
public class AnalyticsAspect {

    @Pointcut("execution(* com.example.CRMdemo.DAO.CustomerDAOImpl.*(..))")
    public void anyDAOMethod(){

    }

    @Before("anyDAOMethod()")
    public void logBeforeDAO(JoinPoint joinPoint){
        System.out.println("Analyzing " + joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.example.CRMdemo.DAO.CustomerDAOImpl.getCustomers(..))",
                    returning = "result")
    public void printOutput(List<Customer> result){
        for (int i = 0; i <result.size() ; i++) {
            System.out.println(result.get(i));

        }

    }
}
