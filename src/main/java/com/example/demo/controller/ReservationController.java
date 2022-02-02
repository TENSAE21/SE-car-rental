package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Reservation;
import com.example.demo.model.ReservationStatus;
import com.example.demo.model.VehicleType;
import com.example.demo.service.ReservationService;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/rental/api/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    VehicleService vehicleService;

    //list
    @GetMapping(value="/list")
    public List<Reservation> getAllReservations(){
        vehicleService.populateVehicleTable();
        reservationService.populateReservations();
        return reservationService.listReservations();
    }

    @GetMapping(value="/list-today")
    public List<Reservation> getTodayReservations(){
        return reservationService.getTodaysReservations();
    }

    @PostMapping(value="/new/{vehicleType}")
    public Reservation makeReservation(@Valid @RequestBody Reservation reservation, @PathVariable VehicleType vehicleType){
        //TODO: how to let the user know if there are no available vehicles for the Type?
        //put number available under vehicle/list by Category
        return reservationService.makeReservation(reservation, vehicleType);
    }


    //update
    @PostMapping(value="/update/{reservationId}")
    public Reservation updateReservation (@Valid @RequestBody Reservation reservation, @PathVariable Long reservationId, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
        }
        else{
            System.out.println("It's fine");
        }
        return reservationService.updateReservation(reservationId, reservation);
    }


    //update-status
    @PostMapping(value="/update-status/{id}/{newReservationStatus}")
    public Reservation updateReservation (@PathVariable Long id, @PathVariable ReservationStatus newReservationStatus){

        return reservationService.updateReservationStatus(newReservationStatus, id);
    }

    //delete
    @DeleteMapping(value="/delete/{reservationId}")
    public void deleteReservation (@Valid @PathVariable Long reservationId)
    {
         reservationService.deleteReservation(reservationId);
    }

    //get
    @GetMapping(value="/get/{reservationId}")
    public Reservation getReservation(@PathVariable Long reservationId){
        return reservationService.getReservation(reservationId);
    }

}
