package com.example.demo.service;


import com.example.demo.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    public Reservation add(Reservation v);
    public Reservation getReservation(Long id);
    public List<Reservation> listReservations();
    public Reservation updateReservation(Long reservationId, Reservation reservation);


}
