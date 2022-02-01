package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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

}
