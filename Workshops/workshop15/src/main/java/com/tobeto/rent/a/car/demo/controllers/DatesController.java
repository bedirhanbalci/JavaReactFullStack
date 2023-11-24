package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.DateService;
import com.tobeto.rent.a.car.demo.services.dtos.date.requests.AddDateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.date.requests.UpdateDateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetAllDatesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetDateResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dates")
public class DatesController {

    private final DateService dateService;

    public DatesController(DateService dateService) {
        this.dateService = dateService;
    }

    @PostMapping
    public void add(@RequestBody AddDateRequest addDateRequest) {
        dateService.add(addDateRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        dateService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateDateRequest updateDateRequest) {
        dateService.update(updateDateRequest);
    }

    @GetMapping("{id}")
    public GetDateResponse getById(@PathVariable int id) {
        return dateService.getById(id);
    }

    @GetMapping
    public List<GetAllDatesResponse> getAll() {
        return dateService.getAll();
    }
}