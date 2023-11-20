package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Individual;
import com.tobeto.rent.a.car.demo.repositories.IndividualRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/individuals")
public class IndividualsController {

    private final IndividualRepository individualRepository;

    public IndividualsController(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }

    @GetMapping
    public List<Individual> getAll() {
        List<Individual> individuals = individualRepository.findAll();
        return individuals;
    }

    @GetMapping("{id}")
    public Individual getById(@PathVariable int id) {
        return individualRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Individual individual) {
        individualRepository.save(individual);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Individual individualToDelete = individualRepository.findById(id).orElseThrow();
        individualRepository.delete(individualToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Individual individual) {
        Individual individualToUpdate = individualRepository.findById(id).orElseThrow();
        individualToUpdate.setName(individual.getName());
        individualToUpdate.setSurname(individual.getSurname());
        individualToUpdate.setBirthDate(individual.getBirthDate());
        individualToUpdate.setGender(individual.getGender());
        individualToUpdate.setIdentificationNumber(individual.getIdentificationNumber());
        individualToUpdate.setCustomer(individual.getCustomer());
        individualRepository.save(individualToUpdate);
    }
}
