package com.example.CRMdemo.CustomerController;


import com.example.CRMdemo.Customer;
import com.example.CRMdemo.Service.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/all")
    public List<Customer> getCustomerList(){

        return customerService.getCustomers();

    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id){

        return customerService.getCustomerById(id);

    }





}
