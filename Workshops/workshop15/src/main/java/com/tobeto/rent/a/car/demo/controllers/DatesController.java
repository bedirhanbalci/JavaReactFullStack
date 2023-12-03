package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Date;
import com.tobeto.rent.a.car.demo.services.abstracts.DateService;
import com.tobeto.rent.a.car.demo.services.dtos.date.requests.AddDateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.date.requests.UpdateDateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetAllDatesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetDateResponse;
import com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetListDateResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("all")
    public List<GetAllDatesResponse> getAll() {
        return dateService.getAll();
    }

    @GetMapping("startDate")
    public List<Date> getByStartDate(@RequestParam LocalDate startDate) {
        return dateService.getByStartDate(startDate);
    }

    @GetMapping("between")
    public List<GetListDateResponse> getByEndDateBetween(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return dateService.getByDateBetween(startDate, endDate);
    }

    @GetMapping("isNull")
    public List<GetListDateResponse> getByExtendDateIsNull() {
        return dateService.getByExtendDateIsNull();
    }
}