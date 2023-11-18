package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "customers")
@Entity
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;


    @OneToMany(mappedBy = "customer")
    private List<Corporate> corporate;

    @OneToMany(mappedBy = "customer")
    private List<Individual> individual;

    @OneToMany(mappedBy = "customer")
    private List<Rental> rental;

    @OneToMany(mappedBy = "customer")
    private List<Payment> payment;

}
