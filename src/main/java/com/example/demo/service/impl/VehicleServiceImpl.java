package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    Vehicle v1 = new Vehicle("6564-3893", "LLL-9863", "Toyota", "Camery", "2018", "economy","disel", 8, 142.25);
    Vehicle v2 = new Vehicle("6904-0193", "BKV-9863", "Audi", "TT", "2019", "sedan","sedan", 4, 267.75);
    Vehicle v3 = new Vehicle("6284-1890", "PKL-9863", "Land Rover", "Velar", "2015", "economy","SUV", 8, 158.80);


    @Override
    public Vehicle add(Vehicle vehicle) {
        //Mock
        return v1;
        //Real
//        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicle(Long id) {
        //Mock
        return v1;

        //Real
        //return vehicleRepository.getById(id);

    }

    @Override
    public List<Vehicle> listVehicles() {
        //Mock
        return List.of(v1,v2,v3);

        //Real
//        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicle) {
        //Real
        //TODO: update Vehicle
        //Mock
        return v2;
    }

    @Override
    public void delete(Long vehicleId) {
        //Real
//        vehicleRepository.delete(vehicleId);

    }


}
