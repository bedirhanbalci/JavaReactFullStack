package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.OptionService;
import com.tobeto.rent.a.car.demo.services.dtos.option.requests.AddOptionRequest;
import com.tobeto.rent.a.car.demo.services.dtos.option.requests.UpdateOptionRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/options")
public class OptionsController {

    private final OptionService optionService;

    public OptionsController(OptionService optionService) {
        this.optionService = optionService;
    }

    @PostMapping
    public void add(@RequestBody AddOptionRequest addOptionRequest) {
        optionService.add(addOptionRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        optionService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateOptionRequest updateOptionRequest) {
        optionService.update(updateOptionRequest);
    }
}