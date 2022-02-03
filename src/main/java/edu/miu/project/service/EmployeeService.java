package edu.miu.project.service;

import edu.miu.project.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

   public Boolean signIn(Employee emp); //TODO: should return employee?
   public Employee addEmployee(Employee employee);
   public Employee findEmployeeByUserName(String userName);
   public Employee updateEmployee(Employee employee, long id);
   public void deleteEmployee(long employeeId);
   public List<Employee> getEmployees();
   public void populateEmployees();



}
