package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

   public Boolean signIn(Employee emp);
}
