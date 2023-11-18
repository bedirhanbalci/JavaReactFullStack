package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "dates")
@Entity
public class Date {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_date")
    private java.sql.Date startDate;

    @Column(name = "end_date")
    private java.sql.Date endDate;

    @Column(name = "extend_date")
    private java.sql.Date extendDate;


    @OneToMany(mappedBy = "date")
    private List<Rental> rental;
}
