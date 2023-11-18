package com.tobeto.rent.a.car.demo.entities;

import jakarta.persistence.*;

@Table(name = "corporates")
@Entity
public class Corporate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_title")
    private String contactTitle;

    @Column(name = "tax_number")
    private String taxNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
