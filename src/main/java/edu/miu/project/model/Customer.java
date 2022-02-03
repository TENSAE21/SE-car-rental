package edu.miu.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String firstName;
    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
