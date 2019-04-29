package com.example.CRMdemo.DAO;

import com.example.CRMdemo.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
          //  Customer c = (Customer) session.get(Customer.class, 1);
            List<Customer> customerList = session.createQuery("from Customer").list();
            session.getTransaction().commit();
            return customerList;
        } finally {
            sessionFactory.close();
        }
    }
}
