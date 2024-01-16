package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "rentals")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "reservation")
    private String reservation;

    @ManyToOne
    @JoinColumn(name = "date_id")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

}