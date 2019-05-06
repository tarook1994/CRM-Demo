package com.example.CRMdemo.DAO;

import com.example.CRMdemo.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();
    public Customer getCustomerById(int id);
    public void deleteCustomer(int id);
}
