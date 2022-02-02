package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

   public Boolean signIn(Employee emp); //TODO: should return employee?
   public Employee addEmployee(Employee employee);
   public Employee updateEmployee(Employee employee, long id);
   public void deleteEmployee(long employeeId);
   public List<Employee> getEmployees();



}
