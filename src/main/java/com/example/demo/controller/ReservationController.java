package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value="/rental/api/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    //add
    @PostMapping(value="/new")
    public Reservation addReservation(@Valid @RequestBody Reservation reservation){
        return reservationService.add(reservation);
    }

    //update
    @PostMapping(value="/update/{reservationId}")
    public Reservation updateReservation (@Valid @RequestBody Reservation reservation, @PathVariable Long reservationId){

        return reservationService.updateReservation(reservationId, reservation);
    }

    //delete
    @DeleteMapping(value="/delete/{reservationId}")
    public void deleteReservation (@Valid @PathVariable Long reservationId)
    {

    }

    //get
    @GetMapping(value="/get/{reservationId}")
    public Reservation getReservation(@PathVariable Long reservationId){
        return reservationService.getReservation(3l);
    }

    //list
    @GetMapping(value="/list")
    public List<Reservation> getAllReservations(){
        return reservationService.listReservations();
    }
}
