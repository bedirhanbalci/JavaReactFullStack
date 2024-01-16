package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "individuals")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private LocalDate birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "identification_number", unique = true)
    private String identificationNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;

}
