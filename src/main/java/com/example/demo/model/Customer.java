package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table(name = "Customers")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String firstName;
    private String lastName;
    private LocalDate DateOfBirth; // TODO: older than 18
    private String dirversLicenseNumber;
    @Email
    private String email;
   // private String cardNumber; // TODO: is this Reservation Number?

    @Embedded
    private Address address;


    public Customer(String firstName, String lastName, LocalDate dateOfBirth, String dirversLicenseNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        DateOfBirth = dateOfBirth;
        this.dirversLicenseNumber = dirversLicenseNumber;
        this.email = email;
  //      this.cardNumber = cardNumber;
    }

    public Customer(String firstName, String lastName, LocalDate dateOfBirth, String dirversLicenseNumber, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        DateOfBirth = dateOfBirth;
        this.dirversLicenseNumber = dirversLicenseNumber;
        this.email = email;
     //   this.cardNumber = cardNumber;
        this.address = address;
    }
}
