package com.example.demo.service.impl;

import com.example.demo.model.Branch;
import com.example.demo.model.FuelType;
import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleType;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    Vehicle v1 = new Vehicle("6564-3893", "LLL-9863", "Honda", "Civic", "2018", VehicleType.SEDAN, FuelType.DIESEL, 5, 42.25, false);
    Vehicle v2 = new Vehicle("6904-0193", "BKV-9863", "Audi", "TT", "2019", VehicleType.SEDAN,FuelType.GASOLINE, 4, 67.75, false);
    Vehicle v3 = new Vehicle("6284-1890", "PKL-9863", "Land Rover", "Velar", "2015", VehicleType.SUV,FuelType.GASOLINE, 8, 58.80, false);

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
//        return v1;

        //Real
        return vehicleRepository.getById(id);

    }

    @Override
    public List<Vehicle> listVehicles() {
        //Mock
//        return List.of(v1,v2,v3);

        //Real
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle updateVehicle(Long vehicleId, Vehicle editedVehicle) {
        //Real
        //TODO: update Vehicle
        return vehicleRepository.findById(vehicleId)
                .map(vehicleToUpdate -> {
                    vehicleToUpdate.setBranch(editedVehicle.getBranch());
                    vehicleToUpdate.setIsReserved(editedVehicle.getIsReserved());
                    vehicleToUpdate.setCapacity(editedVehicle.getCapacity());
                    vehicleToUpdate.setFuel(editedVehicle.getFuel());
                    vehicleToUpdate.setDailyPrice(editedVehicle.getDailyPrice());
                    vehicleToUpdate.setMake(editedVehicle.getMake());
                    vehicleToUpdate.setModel(editedVehicle.getModel());
                    vehicleToUpdate.setType(editedVehicle.getType());
                    vehicleToUpdate.setVinNumber(editedVehicle.getVinNumber());
                    vehicleToUpdate.setPlateNumber(editedVehicle.getPlateNumber());
                    vehicleToUpdate.setYear(editedVehicle.getYear());
                    return vehicleRepository.save(vehicleToUpdate);
                }).orElse(null);
        //Mock
       // return v2;
    }

    @Override
    public Boolean updateVehicleStatus(Long vehicleId, boolean isReserved) {
         return vehicleRepository.updateVehicleReservationStatus(isReserved, vehicleId);
    }

    @Override
    public void delete(Long vehicleId) {
        //Real
        vehicleRepository.deleteByVehicleId(vehicleId);
    }

    @Override
    public List<Vehicle> findUnreservedByType(VehicleType type) {
        return vehicleRepository.findVehiclesByTypeAndIsReserved(type, false);
    }

    @Override
    public void populateVehicleTable(){
        if(vehicleRepository.findAll().isEmpty()) {
            Vehicle v1 = new Vehicle("6564-3893", "LLL-9863", "Honda", "Civic", "2018", VehicleType.SEDAN,FuelType.DIESEL, 5, 142.25, false, Branch.LOS_ANGELES1);
            vehicleRepository.save(v1);
            Vehicle v2 = new Vehicle("6904-0193", "BKV-9863", "Audi", "TT", "2019", VehicleType.SEDAN,FuelType.GASOLINE, 4, 267.75, false,Branch.LOS_ANGELES2);
            vehicleRepository.save(v2);
            Vehicle v3 = new Vehicle("6284-1890", "PKL-9863", "Land Rover", "Velar", "2015", VehicleType.SUV,FuelType.GASOLINE, 8, 158.80, false,Branch.LOS_ANGELES2);
            vehicleRepository.save(v3);
        }
    }
}
