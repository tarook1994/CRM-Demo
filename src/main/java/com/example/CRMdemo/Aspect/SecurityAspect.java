package com.example.CRMdemo.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecurityAspect {



    @Pointcut("execution(* com.example.CRMdemo.DAO.CustomerDAOImpl.*(..))")
    public void anyDAOMethod(){

    }

    @Before("anyDAOMethod()")
    public void logBeforeDAO(){
        System.out.println("Securing");
    }
}
