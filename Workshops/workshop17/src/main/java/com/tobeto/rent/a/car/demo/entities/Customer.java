package com.tobeto.rent.a.car.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "customers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "address")
    private String address;


    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Corporate> corporate;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Individual> individual;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Rental> rental;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Payment> payment;
}
