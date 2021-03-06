package com.example.CRMdemo.Service;

import com.example.CRMdemo.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerService {


    @Transactional
    List<Customer> getCustomers();

    @Transactional
    Customer getCustomerById(int id);

    @Transactional
    void deleteCustomer(int id);

    @Transactional
    String addCustomer(Customer customer);

    @Transactional
    String updateCustomer(Customer customer, int id);
}
