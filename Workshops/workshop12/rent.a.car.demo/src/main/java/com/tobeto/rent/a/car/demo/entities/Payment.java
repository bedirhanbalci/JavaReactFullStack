package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "payments")
@Entity
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "weekly_price")
    private double weeklyPrice;

    @Column(name = "monthly_price")
    private double monthlyPrice;

    @Column(name = "assurance_price")
    private double assurancePrice;

    @Column(name = "fuel_price")
    private double fuelPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "payment")
    private List<Rental> rental;

    @OneToMany(mappedBy = "payment")
    private List<Price> price;
}
