package edu.miu.project.service;


import edu.miu.project.model.Reservation;
import edu.miu.project.model.ReservationStatus;
import edu.miu.project.model.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    public void populateReservations();
    public Reservation add(Reservation v);
    public Reservation getReservation(Long id);
    public List<Reservation> listReservations();
    public Reservation updateReservation(Long reservationId, Reservation reservation);
    public Reservation makeReservation(Reservation reservation, VehicleType vehicleType);
    public List<Reservation>getTodaysReservations();
    public void deleteReservation(Long id);
    public Reservation updateReservationStatus(ReservationStatus reservationStatus, Long id);

}
