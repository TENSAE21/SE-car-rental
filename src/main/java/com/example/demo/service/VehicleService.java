package com.example.demo.service;

import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
      public Vehicle add(Vehicle v);
      public Vehicle getVehicle(Long id);
      public List<Vehicle> listVehicles();
      public Vehicle updateVehicle(Long vehicleId, Vehicle vehicle);
      public Boolean updateVehicleStatus(Long vehicleId, boolean isReserved);
      public void delete(Long vehicleId);
      public List<Vehicle> findUnreservedByType(VehicleType vehicleType);
      public void populateVehicleTable();

}
