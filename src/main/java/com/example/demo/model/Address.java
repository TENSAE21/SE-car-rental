package com.example.demo.model;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Address implements ValueObject{
    private String state;
    private String city;
    private String street;
    private String zipCode;


}
