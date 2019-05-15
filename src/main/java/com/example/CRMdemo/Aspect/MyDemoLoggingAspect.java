package com.example.CRMdemo.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyDemoLoggingAspect {

    @Before("execution(* com.example.CRMdemo.DAO.CustomerDAOImpl.getCustomers())")
    public void beforeAddAccount(){

        System.out.println("Execution before getCustomers");

    }


}
