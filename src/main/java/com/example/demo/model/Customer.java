package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table(name = "Customers")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private LocalDate DateOfBirth; // TODO: older than 18?
    @Column(nullable = false)
    private String driversLicenseNumber;
    @Email
    private String email;


    @JsonBackReference
    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
    Reservation reservation;
    @Embedded
    private Address address;


    public Customer(String firstName, String lastName, LocalDate dateOfBirth, String driversLicenseNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        DateOfBirth = dateOfBirth;
        this.driversLicenseNumber = driversLicenseNumber;
        this.email = email;
    }

    public Customer(String firstName, String lastName, LocalDate dateOfBirth, String driversLicenseNumber, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        DateOfBirth = dateOfBirth;
        this.driversLicenseNumber = driversLicenseNumber;
        this.email = email;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", driversLicenseNumber='" + driversLicenseNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
