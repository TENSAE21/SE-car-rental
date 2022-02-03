package edu.miu.project.service;

import edu.miu.project.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public Customer getCustomer(Long customerId);
    public List<Customer> getAllCustomers();
    public void deleteCustomer(Long customerId);
}
