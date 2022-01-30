package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Vehicles")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Vehicle {

    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;
    private String vinNumber;
    private String plateNumber;
    private String make;
    private String model;
    private String year;
    private String type;
    private String fuel;
    private String capacity;
    private Double price;

    @Embedded
    private Address branchAddress;


    public Vehicle(String vinNumber, String plateNumber, String make, String model, String year, String type, String fuel, String capacity, Double price) {
        this.vinNumber = vinNumber;
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.fuel = fuel;
        this.capacity = capacity;
        this.price = price;
    }

    public Vehicle(String vinNumber, String plateNumber, String make, String model, String year, String type, String fuel, String capacity, Double price, Address branchAddress) {
        this.vinNumber = vinNumber;
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.fuel = fuel;
        this.capacity = capacity;
        this.price = price;
        this.branchAddress = branchAddress;
    }
}
