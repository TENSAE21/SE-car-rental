package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @Email
    private String email;
    private String phoneNumber;
    @Column(nullable = false)
    private Role role;
    private String userName;
    private String password;  //TODO: should be an encrypted version

    public Employee(String firstName, String lastName, String email, String phoneNumber, Role role, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }
}
