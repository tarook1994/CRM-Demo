package com.example.CRMdemo;


import com.example.CRMdemo.DAO.CustomerDAOImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerDAOImpl customerDAO;

    @GetMapping("/all")
    public List<Customer> getCustomerList(){

        return customerDAO.getCustomers();

    }



}
