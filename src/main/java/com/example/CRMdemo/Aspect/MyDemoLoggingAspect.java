package com.example.CRMdemo.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyDemoLoggingAspect {


    @Pointcut("execution(* com.example.CRMdemo.DAO.CustomerDAOImpl.*Customers())")
    public void customersPointCutDeclaration(){

    }

    @Before("customersPointCutDeclaration()")
    public void beforeAddAccount(){

        System.out.println("Execution before getCustomers");

    }


}
