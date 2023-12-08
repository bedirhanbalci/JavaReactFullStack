package com.tobeto.rent.a.car.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "options")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    private List<Price> price;
}
