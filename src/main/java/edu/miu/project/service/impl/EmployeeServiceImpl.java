package edu.miu.project.service.impl;


import edu.miu.project.repository.EmployeeRepository;
import edu.miu.project.service.EmployeeService;
import edu.miu.project.model.Employee;
import edu.miu.project.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean signIn(Employee emp) {
        //Mock
        return true;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        String encryptedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encryptedPassword);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeByUserName(String userName) {
        return employeeRepository.findEmployeeByUserName(userName);
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
                    employeeToUpdate.setRole(editedEmployee.getRole());
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

    @Override
    public void populateEmployees() {

            if(employeeRepository.findAll().isEmpty()) {
                Employee employee1 = new Employee("Jerry", "Seinfeld","seinfeld@gmail.com","321-526-9087", Role.ADMIN,"JERRY123","Kramer" );
                Employee employee2 = new Employee("Chandler", "Being","chan_bing@gmail.com","583-194-6273",Role.ADMIN,"chan23","yy" );
                Employee employee3 = new Employee("Lenard", "Hofstadter","lenhofs@gmail.com","721-406-1658",Role.EMPLOYEE,"Hofman","physics" );

                employeeRepository.saveAll(List.of(employee1,employee2,employee3));
//                employeeRepository.save(v2);
//                employeeRepository.save(v3);

        }
    }


}
