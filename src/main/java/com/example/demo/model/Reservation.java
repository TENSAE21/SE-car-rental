package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "Reservations")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Reservation {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "reservation_id")
   private Long reservationId;

   @Column(nullable = false, unique = true)
   private String reservationNumber;
   private LocalDate startDate;
   private LocalDate endDate;
   private long totalDays;//TODO: can this be calculated from startDate and EndDate
   private Double price;
   private ReservationStatus reservationStatus;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="customer_id", nullable = false)
   private Customer customer;

   @OneToOne
   @JoinColumn(name="vehicle_id", nullable = false)
   private Vehicle vehicle;

   public Reservation(LocalDate startDate, LocalDate endDate, Customer customer, Vehicle vehicle) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.totalDays = DAYS.between(startDate, endDate);
      this.price = calculatePrice(totalDays, vehicle.getDailyPrice());
      this.customer = customer;
      this.vehicle = vehicle;
   }

   public Reservation(LocalDate startDate, LocalDate endDate, Customer customer) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.totalDays = DAYS.between(startDate, endDate);
      this.customer = customer;
   }

   public void setVehicle(Vehicle vehicle) {
      this.price = calculatePrice(totalDays, vehicle.getDailyPrice());
      this.vehicle = vehicle;
   }

   double calculatePrice(long days, double vehicleDailyPrice){
            return days * vehicleDailyPrice;
   }

}
