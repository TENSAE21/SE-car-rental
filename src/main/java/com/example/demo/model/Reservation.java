package com.example.demo.model;

import java.time.LocalDate;

public class Reservation {

   private Long reservationId;
   private Customer customer;
   private Vehicle vehicle;
   private LocalDate startDate;
   private LocalDate endDate;
   private float totalDays;//TODO: can this be calculated from startDate and EndDate
   private Double price;

   Reservation(){}

   public Reservation(Customer customer, Vehicle vehicle, LocalDate startDate, LocalDate endDate, float totalDays, Double price) {
      this.customer = customer;
      this.vehicle = vehicle;
      this.startDate = startDate;
      this.endDate = endDate;
      this.totalDays = totalDays;
      this.price = price;
   }

   public Reservation(Long reservationId, Customer customer, Vehicle vehicle, LocalDate startDate, LocalDate endDate, float totalDays, Double price) {
      this.reservationId = reservationId;
      this.customer = customer;
      this.vehicle = vehicle;
      this.startDate = startDate;
      this.endDate = endDate;
      this.totalDays = totalDays;
      this.price = price;
   }

   public Long getReservationId() {
      return reservationId;
   }

   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public Vehicle getVehicle() {
      return vehicle;
   }

   public void setVehicle(Vehicle vehicle) {
      this.vehicle = vehicle;
   }

   public LocalDate getStartDate() {
      return startDate;
   }

   public void setStartDate(LocalDate startDate) {
      this.startDate = startDate;
   }

   public LocalDate getEndDate() {
      return endDate;
   }

   public void setEndDate(LocalDate endDate) {
      this.endDate = endDate;
   }

   public float getTotalDays() {
      return totalDays;
   }

   public void setTotalDays(float totalDays) {
      this.totalDays = totalDays;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }
}
