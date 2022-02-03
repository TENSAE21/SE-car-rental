package edu.miu.project.controller;

import edu.miu.project.model.Reservation;
import edu.miu.project.model.ReservationStatus;
import edu.miu.project.model.VehicleType;
import edu.miu.project.service.ReservationService;
import edu.miu.project.service.VehicleService;
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
        return reservationService.makeReservation(reservation, vehicleType);
    }


    //update
    @PostMapping(value="/update/{reservationId}")
    public Reservation updateReservation (@Valid @RequestBody Reservation reservation, @PathVariable Long reservationId, BindingResult bindingResult){
        return reservationService.updateReservation(reservationId, reservation);
    }


    //update-status
    @PostMapping(value="/update-status/{id}/{newReservationStatus}")
    public Reservation updateReservationStatus (@PathVariable Long id, @PathVariable ReservationStatus newReservationStatus){
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
