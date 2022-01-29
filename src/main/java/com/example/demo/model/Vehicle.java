package com.example.demo.model;

public class Vehicle {

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
    private Address branchAddress;

    public Vehicle (){}

    public Vehicle(Long vehicleId, String vinNumber, String plateNumber, String make, String model, String year, String type, Double price, Address branchAddress) {
        this.vehicleId = vehicleId;
        this.vinNumber = vinNumber;
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.price = price;
        this.branchAddress = branchAddress;
    }

    public Vehicle(Long vehicleId, String vinNumber, String plateNumber, String make, String model, String year, String type, String fuel, String capacity, Double price, Address branchAddress) {
        this.vehicleId = vehicleId;
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

    public Long getVehicleId() {
        return vehicleId;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Address getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(Address branchAddress) {
        this.branchAddress = branchAddress;
    }
}
