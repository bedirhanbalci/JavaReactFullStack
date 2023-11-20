package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Option;
import com.tobeto.rent.a.car.demo.repositories.OptionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/options")
public class OptionsController {

    private final OptionRepository optionRepository;

    public OptionsController(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @GetMapping
    public List<Option> getAll() {
        List<Option> options = optionRepository.findAll();
        return options;
    }

    @GetMapping("{id}")
    public Option getById(@PathVariable int id) {
        return optionRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Option option) {
        optionRepository.save(option);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Option optionToDelete = optionRepository.findById(id).orElseThrow();
        optionRepository.delete(optionToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Option option) {
        Option optionToUpdate = optionRepository.findById(id).orElseThrow();
        optionToUpdate.setRentalCancellationPrice(option.getRentalCancellationPrice());
        optionToUpdate.setAdditionalDriverPrice(option.getAdditionalDriverPrice());
        optionToUpdate.setRoadsideAssistancePrice(option.getRoadsideAssistancePrice());
        optionRepository.save(optionToUpdate);
    }
}