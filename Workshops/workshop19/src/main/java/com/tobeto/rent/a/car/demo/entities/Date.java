package com.tobeto.rent.a.car.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "dates")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Date {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "extend_date")
    private LocalDate extendDate;


    @OneToMany(mappedBy = "date")
    @JsonIgnore
    private List<Rental> rental;

}
