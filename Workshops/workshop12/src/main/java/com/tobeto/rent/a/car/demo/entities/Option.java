package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "options")
@Entity
public class Option {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rental_cancellation_price")
    private double rentalCancellationPrice;

    @Column(name = "additional_driver_price")
    private double additionalDriverPrice;

    @Column(name = "roadside_assistance_price")
    private double roadsideAssistancePrice;

    @OneToMany(mappedBy = "option")
    private List<Price> price;
}
