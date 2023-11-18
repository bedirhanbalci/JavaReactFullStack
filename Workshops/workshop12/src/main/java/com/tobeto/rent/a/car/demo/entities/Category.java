package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "categories")
@Entity
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    // one-to-many ilişkilerde list olan değişken @onetomany
    // direkt class olan değişken @manytoone


    @OneToMany(mappedBy = "category")     // değişken ismi tablodaki değil! car class'ımda tanımladığım değişken ismi
    private List<Car> car;

}
