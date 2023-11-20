package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Rental;
import com.tobeto.rent.a.car.demo.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {

    private final RentalRepository rentalRepository;

    public RentalsController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @GetMapping
    public List<Rental> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals;
    }

    @GetMapping("{id}")
    public Rental getById(@PathVariable int id) {
        return rentalRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Rental rental) {
        rentalRepository.save(rental);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Rental rental) {
        Rental rentalToUpdate = rentalRepository.findById(id).orElseThrow();
        rentalToUpdate.setPayment(rental.getPayment());
        rentalToUpdate.setCustomer(rental.getCustomer());
        rentalToUpdate.setCar(rental.getCar());
        rentalToUpdate.setDate(rental.getDate());
        rentalToUpdate.setLocation(rental.getLocation());
        rentalToUpdate.setReservation(rental.getReservation());
        rentalRepository.save(rentalToUpdate);
    }
}