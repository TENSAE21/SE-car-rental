package edu.miu.project.model;

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
    @Column(nullable = false, unique = true)
    private String vinNumber;
    @Column(nullable = false, unique = true)
    private String plateNumber;
    private String make;
    private String model;
    private String year;
    @Column(nullable = false)
    private VehicleType type;
    private FuelType fuel;
    private int capacity;
    private Double dailyPrice;
    private Boolean isReserved;
    private Branch branch;


    public Vehicle(String vinNumber, String plateNumber, String make, String model, String year, VehicleType type, FuelType fuel, int capacity, Double dailyPrice, boolean isReserved) {
        this.vinNumber = vinNumber;
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.fuel = fuel;
        this.capacity = capacity;
        this.dailyPrice = dailyPrice;
        this.isReserved = isReserved;
    }

    public Vehicle(String vinNumber, String plateNumber, String make, String model, String year, VehicleType type, FuelType fuel, int capacity, Double dailyPrice, boolean isReserved, Branch branch) {
        this.vinNumber = vinNumber;
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.fuel = fuel;
        this.capacity = capacity;
        this.dailyPrice = dailyPrice;
        this.isReserved= isReserved;
        this.branch = branch;
    }
}
