package com.example.demo.service.impl;

import com.example.demo.model.Address;
import com.example.demo.model.Customer;
import com.example.demo.model.Reservation;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    //For Mocking purposes
    Vehicle v1 = new Vehicle("6564-3893", "LLL-9863", "Honda", "Civic", "2018", "sedan","disel", 5, 142.25);
    Vehicle v2 = new Vehicle("6904-0193", "BKV-9863", "Audi", "TT", "2019", "sedan","sedan", 4, 267.75);
    Vehicle v3 = new Vehicle("6284-1890", "PKL-9863", "Land Rover", "Velar", "2015", "economy","SUV", 8, 158.80);



    Customer c1 = new Customer("Brad", "Pitt", LocalDate.of(1959,8,9), "DR40909","brad34@gmail.com",  new Address("California", "Los Angeles", "Berkley", "89028"));
    Reservation reservation1 = new Reservation(LocalDate.of(2022,2,4), LocalDate.of(2022,2,7),3,224.20, c1, v1);

    Customer c2 = new Customer("Adrian", "Brody", LocalDate.of(1967,2,18), "RU0752","brody26@gmail.com",  new Address("California", "Los Angeles", "Vienna", "89012"));
    Reservation reservation2 = new Reservation(LocalDate.of(2022,2,1), LocalDate.of(2022,2,3),1,164.30, c2, v2);


    Customer c3 = new Customer("Chelsea", "Peretti", LocalDate.of(1975,12,7), "chelsea03@gmail.com", "HT5832", new Address("Ohio", "Dayton", "Folten", "75392"));
    Reservation reservation3 = new Reservation(LocalDate.of(2022,2,16), LocalDate.of(2022,2,18),2,196.43, c3, v3);




    List<Reservation> fakeReservations = List.of(reservation1,reservation2,reservation3);

    @Override
    public Reservation add(Reservation v) {
        //Mock
        return reservation1;

        //Real
//        return reservationRepository.save(v);

    }

    @Override
    public Reservation getReservation(Long id) {
        //Mock
         return reservation2;

         //Real
//        return reservationRepository.getById(id);
    }

    @Override
    public List<Reservation> listReservations() {

        //Mock
        return fakeReservations;

        //Real
        // return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Long reservationId, Reservation reservation)
    {
        //Real
        //TODO:UPDATE QUERY

        //Mock
        return reservation3;
    }


}
