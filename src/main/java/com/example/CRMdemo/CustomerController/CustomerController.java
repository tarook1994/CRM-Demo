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

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //Adding exception handler to catch all exceptions!
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAnyException(Exception exception) {

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public List<Customer> getCustomerList() {

        return customerService.getCustomers();

    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        if (id > 4) {
            throw new StudentNotFoundException("student not found");
        }

        return customerService.getCustomerById(id);

    }


}
