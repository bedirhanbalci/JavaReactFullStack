package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;

@Table(name = "prices")
@Entity
public class Price {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;


}
