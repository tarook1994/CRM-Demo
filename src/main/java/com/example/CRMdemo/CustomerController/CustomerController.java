package com.example.CRMdemo.CustomerController;


import com.example.CRMdemo.Customer;
import com.example.CRMdemo.CustomerController.Exception.StudentNotFoundException;
import com.example.CRMdemo.Service.CustomerServiceImpl;

import com.example.CRMdemo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
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

    @CrossOrigin
    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){

        return customerService.addCustomer(customer);
    }


}
