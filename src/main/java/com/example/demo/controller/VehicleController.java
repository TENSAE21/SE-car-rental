package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
//@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:81"}, allowedHeaders = "*")
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/rental/api/vehicle", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleController {

    @Autowired
    VehicleService vehicleService;


    //list - by employee and Admin
    @GetMapping(value="/list")
    public List<Vehicle> allVehicles(){
        vehicleService.populateVehicleTable();
        return vehicleService.listVehicles();
    }

    //add - by employee and Admin
    @PostMapping(value="/new")
    public Vehicle addVehicle(@Valid @RequestBody Vehicle vehicle){
        return vehicleService.add(vehicle);
    }

    //update - by employee and Admin
    @PostMapping(value="/update/{vehicleId}")
    public Vehicle updateVehicle (@Valid @RequestBody Vehicle vehicle, @PathVariable Long vehicleId){
        return vehicleService.updateVehicle(vehicleId, vehicle);
    }

    //delete - by employee and Admin
    @DeleteMapping(value="/delete/{vehicleId}")
    public void deleteVehicle (@Valid @PathVariable Long vehicleId)
    {
            vehicleService.delete(vehicleId);
    }

    //get - by employee and Admin
    @GetMapping(value="/get/{vehicleId}")
    public Vehicle getVehicle(@PathVariable Long vehicleId){
        return vehicleService.getVehicle(vehicleId);
    }

}
