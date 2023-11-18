package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;

import java.util.List;

// ORM => Object Relational Mapping
@Table(name = "cars")
@Entity
public class Car {

    @Id                                                     // eğer primary key (PK) ise bu şekilde belirtmemiz gerekiyor
    @Column(name = "id")                                   // name = kolon adı veri tabanındaki hali
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // identity ise bunu böyle belirtmemiz gerekiyor
    private int id;                                      // class'ın içindeki alanın adı

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "color")
    private String color;

    @Column(name = "status")
    private String status;

    @Column(name = "number_plate")
    private String numberPlate;


    // TODO: İlişkisel Brand tablosunun alanlarını eklemek.
    // İlişki class üzerinden yürü
    // tekil ise join colonunu belirtmem lazım (fk kolonu)


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "car")
    private List<Rental> rental;

}
