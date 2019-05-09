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

    @Autowired
    SessionFactory sessionFactory;



    @Override
    public List<Customer> getCustomers() {


        Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
          //  Customer c = (Customer) session.get(Customer.class, 1);
            List<Customer> customerList = session.createQuery("from Customer").list();
            session.getTransaction().commit();
            return customerList;

    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            //  Customer c = (Customer) session.get(Customer.class, 1);
            Customer customer = (Customer) session.get(Customer.class ,id);
            session.getTransaction().commit();
            return customer;

    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Customer customer = (Customer) session.get(Customer.class ,id);
        session.delete(customer);
        session.getTransaction().commit();
    }

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }

    @Override
    public void updateCustomer(Customer customer, int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Customer customerFromDatabase = (Customer) session.get(Customer.class,id);
        customerFromDatabase.setFirstName(customer.getFirstName());
        customerFromDatabase.setLastName(customer.getLastName());
        customerFromDatabase.setEmail(customer.getEmail());
        session.getTransaction().commit();
    }
}
