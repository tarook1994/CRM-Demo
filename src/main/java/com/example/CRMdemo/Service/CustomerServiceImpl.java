package com.example.CRMdemo.Service;

import com.example.CRMdemo.Customer;
import com.example.CRMdemo.DAO.CustomerDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDAOImpl customerDAO;

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    public void deleteCustomer(int id) {
         customerDAO.deleteCustomer(id);
    }

    @Override
    public String addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
        return "Customer Added Successfully";
    }
}
