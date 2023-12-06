package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Individual;
import com.tobeto.rent.a.car.demo.services.abstracts.IndividualService;
import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.AddIndividualRequest;
import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.UpdateIndividualRequest;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetAllIndividualsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetIndividualResponse;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetListIndividualResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/individuals")
@AllArgsConstructor
public class IndividualsController {

    private final IndividualService individualService;

    @PostMapping
    public void add(@RequestBody AddIndividualRequest addIndividualRequest) {
        individualService.add(addIndividualRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        individualService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateIndividualRequest updateIndividualRequest) {
        individualService.update(updateIndividualRequest);
    }

    @GetMapping("{id}")
    public GetIndividualResponse getById(@PathVariable int id) {
        return individualService.getById(id);
    }

    @GetMapping("all")
    public List<GetAllIndividualsResponse> getAll() {
        return individualService.getAll();
    }

    @GetMapping("name")
    public List<Individual> getByName(@RequestParam String name) {
        return individualService.getByName(name);
    }

    @GetMapping("surname")
    public List<Individual> getBySurname(@RequestParam String surname) {
        return individualService.getBySurname(surname);
    }

    @GetMapping("maleGender")
    public List<GetListIndividualResponse> getByGender() {
        return individualService.getByGender();
    }

    @GetMapping("orderBy")
    public List<GetListIndividualResponse> getByOrderByBirthDate() {
        return individualService.getByOrderByBirthDate();
    }
}