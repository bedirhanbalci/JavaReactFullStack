package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.IndividualService;
import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.AddIndividualRequest;
import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.UpdateIndividualRequest;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetAllIndividualsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetIndividualResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/individuals")
public class IndividualsController {

    private final IndividualService individualService;


    public IndividualsController(IndividualService individualService) {
        this.individualService = individualService;
    }

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

    @GetMapping
    public List<GetAllIndividualsResponse> getAll() {
        return individualService.getAll();
    }
}