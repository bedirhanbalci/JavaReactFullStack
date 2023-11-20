package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Date;
import com.tobeto.rent.a.car.demo.repositories.DateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dates")
public class DatesController {

    private final DateRepository dateRepository;

    public DatesController(DateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    @GetMapping
    public List<Date> getAll() {
        List<Date> dates = dateRepository.findAll();
        return dates;
    }

    @GetMapping("{id}")
    public Date getById(@PathVariable int id) {
        return dateRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Date date) {
        dateRepository.save(date);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Date dateToDelete = dateRepository.findById(id).orElseThrow();
        dateRepository.delete(dateToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Date date) {
        Date dateToUpdate = dateRepository.findById(id).orElseThrow();
        dateToUpdate.setStartDate(date.getStartDate());
        dateToUpdate.setEndDate(date.getEndDate());
        dateToUpdate.setExtendDate(date.getExtendDate());
        dateRepository.save(dateToUpdate);
    }
}
