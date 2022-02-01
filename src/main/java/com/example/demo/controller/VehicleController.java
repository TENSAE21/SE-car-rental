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

    //list
    @GetMapping(value="/list")
    public List<Vehicle> allVehicles(){
        return vehicleService.listVehicles();
    }

    //add
    @PostMapping(value="/new")
    public Vehicle addVehicle(@Valid @RequestBody Vehicle vehicle){
        return vehicleService.add(vehicle);
    }

    //update
    @PostMapping(value="/update/{vehicleId}")
    public Vehicle updateVehicle (@Valid @RequestBody Vehicle vehicle, @PathVariable Long vehicleId){
        return vehicleService.updateVehicle(vehicleId, vehicle);
    }

    //delete
    @DeleteMapping(value="/delete/{vehicleId}")
    public void deleteVehicle (@Valid @PathVariable Long vehicleId)
    {
            vehicleService.delete(vehicleId);
    }

    //get
    @GetMapping(value="/get/{vehicleId}")
    public Vehicle getVehicle(@PathVariable Long vehicleId){
        return vehicleService.getVehicle(3l);
    }

}
