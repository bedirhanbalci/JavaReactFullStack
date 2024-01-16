package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "prices")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
