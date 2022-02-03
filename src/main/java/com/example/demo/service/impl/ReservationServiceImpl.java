package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ReservationService;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;



@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    CustomerService customerService;

    //For Mocking purposes
//    Vehicle v1 = new Vehicle("6564-3893", "LLL-9863", "Honda", "Civic", "2018", VehicleType.SEDAN,FuelType.DIESEL, 5, 142.25, false);
//    Vehicle v2 = new Vehicle("6904-0193", "BKV-9863", "Audi", "TT", "2019", VehicleType.SEDAN,FuelType.GASOLINE, 4, 267.75, false);
//    Vehicle v3 = new Vehicle("6284-1890", "PKL-9863", "Land Rover", "Velar", "2015", VehicleType.SUV,FuelType.GASOLINE, 8, 158.80, false);
//


//    Customer c1 = new Customer("Brad", "Pitt", LocalDate.of(1959,8,9), "DR40909","brad34@gmail.com",  new Address("California", "Los Angeles", "Berkley", "89028"));
//    Reservation reservation1 = new Reservation(LocalDate.of(2022,2,4), LocalDate.of(2022,2,7), c1, v1);
//
//    Customer c2 = new Customer("Adrian", "Brody", LocalDate.of(1967,2,18), "RU0752","brody26@gmail.com",  new Address("California", "Los Angeles", "Vienna", "89012"));
//    Reservation reservation2 = new Reservation(LocalDate.of(2022,2,1), LocalDate.of(2022,2,3), c2, v2);
//
//
//    Customer c3 = new Customer("Chelsea", "Peretti", LocalDate.of(1975,12,7), "chelsea03@gmail.com", "HT5832", new Address("Ohio", "Dayton", "Folten", "75392"));
//    Reservation reservation3 = new Reservation(LocalDate.of(2022,2,16), LocalDate.of(2022,2,18), c3, v3);
//
//
//    List<Reservation> fakeReservations = List.of(reservation1,reservation2,reservation3);

    @Override
    public Reservation add(Reservation v) {
        //Mock
//        return reservation1;

        //Real
        return reservationRepository.save(v);

    }



    @Override
    public Reservation getReservation(Long id) {
        //Mock
         //return reservation2;

         //Real
        return reservationRepository.getById(id);
    }

    @Override
    public List<Reservation> listReservations() {

        //Mock
        //return fakeReservations;

        //Real
         return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Long reservationId, Reservation editedReservation) {
        //Real
        //TODO:UPDATE QUERY

        System.out.println(editedReservation);
        return reservationRepository.findById(reservationId)
                .map(resToUpdate -> {
                    System.out.println(resToUpdate);
                    resToUpdate.setStartDate(editedReservation.getStartDate());
                    resToUpdate.setEndDate(editedReservation.getEndDate());
                    System.out.println("------UPDATED-------");
                    return reservationRepository.save(resToUpdate);
                }).orElse(null);
//                    return reservationRepository.save(editedReservation;
//                });

        //Mock
//        return reservationRepository.getById(1l);

    }

    @Override
    public Reservation makeReservation(Reservation reservation, VehicleType vehicleType) {
        if (!olderThanEighteen(reservation.getCustomer().getDateOfBirth()))
        {
            //TODO: how to notify UI side??? or should the check be on the UI side??
        }

        List<Vehicle> matchingVehicles = vehicleService.findUnreservedByType(vehicleType);
        if(!matchingVehicles.isEmpty()){
            Vehicle vehicle = matchingVehicles.get(0);
            reservation.setVehicle(vehicle);
            matchingVehicles.get(0).setIsReserved(true);
            reservation.setReservationNumber(generateReservationNumber());
            System.out.println("----------SAVED RESERVATION------------------");
            return reservationRepository.save(reservation);
        }

        //No vehicles of type available for reservation
        return null;
    }

    @Override
    public List<Reservation> getTodaysReservations() {
       return reservationRepository.findReservationsByStartDate(LocalDate.now());
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation updateReservationStatus(ReservationStatus reservationStatus, Long id) {

        if(reservationStatus.equals(ReservationStatus.COMPLETED)){

            return reservationRepository.findById(id)
                    .map(reservation -> {
                        reservation.getVehicle().setIsReserved(false);
                        reservation.setReservationStatus(ReservationStatus.COMPLETED);
                        return reservationRepository.save(reservation);
                    }).orElse(null);
        }
        return reservationRepository.findById(id)
                .map(reservation -> {
                    reservation.setReservationStatus(ReservationStatus.COMPLETED);
                    return reservationRepository.save(reservation);
                }).orElse(null);
    }


    @Override
    public void populateReservations(){

        if(reservationRepository.findAll().isEmpty()) {
            Customer c2 = new Customer("Oprah", "Winfrey", LocalDate.of(1968,2,18), "RU0752","winfrey26@gmail.com",  new Address("California", "Los Angeles", "Vienna", "89012"));
            Reservation reservation2 = new Reservation(LocalDate.now(), LocalDate.now().plusDays(3), c2);
            makeReservation(reservation2, VehicleType.SEDAN);


            Customer c1 = new Customer("Brad", "Pitt", LocalDate.of(1972, 8, 9), "DR40909", "brad34@gmail.com", new Address("California", "Los Angeles", "Berkley", "39028"));
            Reservation reservation1 = new Reservation(LocalDate.now(), LocalDate.now().plusDays(2), c1);
            makeReservation(reservation1, VehicleType.SEDAN);


            Customer c3 = new Customer("Adrian", "Brody", LocalDate.of(1974,10,23), "BM57210","brody26@gmail.com",  new Address("California", "Los Angeles", "eurika", "60927"));
            Reservation reservation3 = new Reservation(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1), c3);
            makeReservation(reservation3, VehicleType.SUV);

            Customer sample = customerService.getCustomer(5l);
            System.out.println(sample);
            System.out.println(sample.getReservation());

        }

//        Customer c3 = new Customer("Chelsea", "Peretti", LocalDate.of(1975,12,7), "chelsea03@gmail.com", "HT5832", new Address("Ohio", "Dayton", "Folten", "75392"));
//        Reservation reservation3 = new Reservation(LocalDate.of(2022,2,16), LocalDate.of(2022,2,18), c3, v3);
//        reservationRepository.save(reservation3);

    }

    String generateReservationNumber()
    {
          return UUID.randomUUID().toString();
    }

    boolean olderThanEighteen(LocalDate dateOfBirth){
        int years = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return years > 18;
    }

}
