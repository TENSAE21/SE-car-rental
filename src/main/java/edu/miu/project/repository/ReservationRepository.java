package edu.miu.project.repository;

import edu.miu.project.model.Reservation;
import edu.miu.project.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationsByStartDate(LocalDate date);

    @Modifying
    @Query("update Reservation r set r.reservationStatus = ?1 where r.reservationId = ?2")
    Integer updateReservationStatus(ReservationStatus status, long id);

}
