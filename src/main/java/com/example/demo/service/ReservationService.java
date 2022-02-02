package com.example.demo.service;


import com.example.demo.model.Customer;
import com.example.demo.model.Reservation;
import com.example.demo.model.VehicleType;
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

}
