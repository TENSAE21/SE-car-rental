package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
//@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:81"}, allowedHeaders = "*")
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/rental/api/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/signin")
    public Boolean signIn(@Valid @RequestBody Employee employee){
        return employeeService.signIn(employee);
    }

    //ADMIN ONLY
    @PostMapping(value= "/add-employee")
    public Employee addEmployee(@Valid @RequestBody Employee employee){

        return employeeService.addEmployee(employee);
    }

    //ADMIN ONLY
    @GetMapping(value="/list")
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    //ADMIN ONLY
    @PostMapping(value= "/update/{employeeId}")
    public Employee updateEmployee(@Valid @RequestBody Employee employee, @PathVariable Long employeeId){
        return employeeService.updateEmployee(employee, employeeId);
    }

    //ADMIN ONLY
    @DeleteMapping(value= "/delete/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }

}
