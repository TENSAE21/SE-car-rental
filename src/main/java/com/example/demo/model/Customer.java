package com.example.demo.model;

import javax.persistence.Entity;
import java.time.LocalDate;


public class Customer {

    private Long customerId;
    private String firstName;
    private String lastName;
    private LocalDate DateOfBirth; // TODO: older than 18
    private String dirversLicenseNumber;
    private String email; // TODO: validated email String
    private String cardNumber; // TODO: is this Reservation Number?
    private Address address;


    public Customer (){}

    public Customer(String firstName, String lastName, LocalDate dateOfBirth, String dirversLicenseNumber, String email, String cardNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        DateOfBirth = dateOfBirth;
        this.dirversLicenseNumber = dirversLicenseNumber;
        this.email = email;
        this.cardNumber = cardNumber;
        this.address = address;
    }

    public Customer(Long customerId, String firstName, String lastName, LocalDate dateOfBirth, String dirversLicenseNumber, String email, String cardNumber, Address address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        DateOfBirth = dateOfBirth;
        this.dirversLicenseNumber = dirversLicenseNumber;
        this.email = email;
        this.cardNumber = cardNumber;
        this.address = address;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getDirversLicenseNumber() {
        return dirversLicenseNumber;
    }

    public void setDirversLicenseNumber(String dirversLicenseNumber) {
        this.dirversLicenseNumber = dirversLicenseNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
