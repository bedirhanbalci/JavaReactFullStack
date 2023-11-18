package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Table(name = "individuals")
@Entity
public class Individual {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "identification_number")
    private String identificationNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
