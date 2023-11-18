package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "locations")
@Entity
public class Location {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pick_up_location")
    private String pickUpLocation;

    @Column(name = "drop_off_location")
    private String dropOffLocation;

    @OneToMany(mappedBy = "location")
    private List<Rental> rental;
}
