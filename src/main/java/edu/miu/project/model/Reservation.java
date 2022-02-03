package edu.miu.project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

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
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDate startDate;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDate endDate;
   private long totalDays;
   private Double price;
   private ReservationStatus reservationStatus;

   @JsonManagedReference
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="customer_id", nullable = false)
   private Customer customer;

   @OneToOne(cascade = CascadeType.MERGE)
   @JoinColumn(name="vehicle_id", nullable = false)
   private Vehicle vehicle;

   public Reservation(LocalDate startDate, LocalDate endDate, Customer customer, Vehicle vehicle) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.totalDays = DAYS.between(startDate, endDate);
      this.price = calculatePrice(totalDays, vehicle.getDailyPrice());
      this.customer = customer;
      this.vehicle = vehicle;
      this.reservationStatus= ReservationStatus.RESERVED;
   }

   public Reservation(LocalDate startDate, LocalDate endDate, Customer customer) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.totalDays = DAYS.between(startDate, endDate);
      this.customer = customer;
      this.reservationStatus= ReservationStatus.RESERVED;
   }

   public void setVehicle(Vehicle vehicle) {
      this.price = calculatePrice(totalDays, vehicle.getDailyPrice());
      this.vehicle = vehicle;
   }

   double calculatePrice(long days, double vehicleDailyPrice){
            return days * vehicleDailyPrice;
   }

}
