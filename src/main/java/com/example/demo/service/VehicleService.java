package com.example.demo.service;

import com.example.demo.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
      public Vehicle add(Vehicle v);
      public Vehicle getVehicle(Long id);
      public List<Vehicle> listVehicles();
      public Vehicle updateVehicle(Long vehicleId, Vehicle vehicle);
      public void delete(Long vehicleId);


}
