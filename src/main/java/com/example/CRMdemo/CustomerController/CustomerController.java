package com.example.CRMdemo.CustomerController;


import com.example.CRMdemo.Customer;
import com.example.CRMdemo.CustomerController.Exception.StudentNotFoundException;
import com.example.CRMdemo.POJOs.StudentErrorResponse;
import com.example.CRMdemo.Service.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerServiceImpl customerService;


    @CrossOrigin
    @GetMapping("/all")
    public List<Customer> getCustomerList() {

        return customerService.getCustomers();

    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        if (id > 4) {
            throw new StudentNotFoundException("student not found");
        }

        return customerService.getCustomerById(id);

    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        return "Deleted Successfully";
    }


}
