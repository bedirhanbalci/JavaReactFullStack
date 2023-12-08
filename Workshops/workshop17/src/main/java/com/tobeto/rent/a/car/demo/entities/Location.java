package com.tobeto.rent.a.car.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "locations")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    private List<Rental> rental;
}
