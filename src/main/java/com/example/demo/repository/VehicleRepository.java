package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


    List<Vehicle> findVehiclesByTypeAndIsReserved(VehicleType type, boolean reserved);
    void deleteByVehicleId(Long vehicleId);
    //findStudentsByStudentNumberGreaterThan(long studentNumber);
}
