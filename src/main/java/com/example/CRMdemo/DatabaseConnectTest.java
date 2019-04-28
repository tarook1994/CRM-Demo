package com.example.CRMdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnectTest {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructiorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            Course c=  session.get(Course.class, 10);
            System.out.println(c.getTitle());
            session.getTransaction().commit();

        } finally {
            factory.close();

        }


    }
}
