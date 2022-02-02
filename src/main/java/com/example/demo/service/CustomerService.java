package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    public Customer getCustomer(Long customerId);
}
