package edu.miu.project.controller;


import edu.miu.project.model.Customer;
import edu.miu.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:81"}, allowedHeaders = "*")
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/rental/api/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/list")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }


    @DeleteMapping(value = "/delete/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId)
    {
        customerService.deleteCustomer(customerId);
    }


}
