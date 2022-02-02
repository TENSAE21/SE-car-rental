package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public Customer getCustomer(Long customerId);
    public List<Customer> getAllCustomers();
    public void deleteCustomer(Long customerId);
}
