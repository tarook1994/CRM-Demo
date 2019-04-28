package com.example.CRMdemo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


    SessionFactory sessionFactory;

    @GetMapping("/")
    public Customer getCustomer(){

        sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Customer c=  (Customer) session.get(Customer.class, 1);
            System.out.println(c.getFirstName());
            session.getTransaction().commit();
            return c;
        } finally {
            sessionFactory.close();
        }


    }

}
