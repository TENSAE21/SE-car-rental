package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String role; //TODO: ENUM??
    private String userName;
    private String password;  //TODO: should be an encrypted version

    public Employee(String firstName, String lastName, String email, String phoneNumber, String role, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }
}
