package com.example.CRMdemo.Service;

import com.example.CRMdemo.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerService {


    @Transactional
    List<Customer> getCustomers();

    @Transactional
    Customer getCustomerById(int id);
}
