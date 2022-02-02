package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.Reservation;
import com.example.demo.model.ReservationStatus;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Boolean signIn(Employee emp) {
        //Mock
        return true;
    }

    @Override
    public Employee addEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee editedEmployee, long id) {
        return employeeRepository.findById(id)
                .map(employeeToUpdate -> {
                    employeeToUpdate.setFirstName(editedEmployee.getFirstName());
                    employeeToUpdate.setLastName(editedEmployee.getLastName());
                    employeeToUpdate.setEmail(editedEmployee.getEmail());
                    employeeToUpdate.setUserName(editedEmployee.getUserName());
                    employeeToUpdate.setPassword(editedEmployee.getPassword());
                    return employeeRepository.save(editedEmployee);
                }).orElse(null);
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


}
