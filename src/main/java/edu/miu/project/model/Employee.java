package edu.miu.project.model;

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
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotNull
    @NotBlank
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name = "LAST_NAME")
    private String lastName;

    @Email
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ROLE", nullable = false)
    private Role role;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
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
