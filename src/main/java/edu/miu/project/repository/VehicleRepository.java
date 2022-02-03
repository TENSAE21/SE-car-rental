package edu.miu.project.repository;

import edu.miu.project.model.Vehicle;
import edu.miu.project.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


    List<Vehicle> findVehiclesByTypeAndIsReserved(VehicleType type, boolean reserved);
    void deleteByVehicleId(Long vehicleId);


    @Modifying
    @Query("update Vehicle v set v.isReserved = ?1 where v.vehicleId = ?2")
    Boolean updateVehicleReservationStatus(boolean isReserved, long id);

}
