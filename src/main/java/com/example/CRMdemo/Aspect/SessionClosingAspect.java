package com.example.CRMdemo.Aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SessionClosingAspect {
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal();


    public void closeSession() {
        Session session = threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    @Pointcut("execution(* com.example.CRMdemo.DAO.CustomerDAOImpl.*(..))")
    public void allDAO() {

    }

    @After("allDAO()")
    public void doCloseSession() {
        closeSession();
    }
}
