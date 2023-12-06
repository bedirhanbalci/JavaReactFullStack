package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Option;
import com.tobeto.rent.a.car.demo.services.abstracts.OptionService;
import com.tobeto.rent.a.car.demo.services.dtos.option.requests.AddOptionRequest;
import com.tobeto.rent.a.car.demo.services.dtos.option.requests.UpdateOptionRequest;
import com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetAllOptionsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetListOptionResponse;
import com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/options")
@AllArgsConstructor
public class OptionsController {
    private final OptionService optionService;

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

    @GetMapping("{id}")
    public GetOptionResponse getById(@PathVariable int id) {
        return optionService.getById(id);
    }

    @GetMapping("all")
    public List<GetAllOptionsResponse> getAll() {
        return optionService.getAll();
    }

    @GetMapping("rentalOrderByDesc")
    public List<Option> getByOrderByRentalCancellationPriceDesc() {
        return optionService.getByOrderByRentalCancellationPriceDesc();
    }

    @GetMapping("driverThanEqual")
    public List<GetListOptionResponse> getByDriverPriceGreaterThanEqual(@RequestParam double additionalDriverPrice) {
        return optionService.getByDriverPriceGreaterThanEqual(additionalDriverPrice);
    }

    @GetMapping("assistanceLessThan")
    public List<GetListOptionResponse> getByAssistancePriceLessThan(@RequestParam double roadsideAssistancePrice) {
        return optionService.getByAssistancePriceLessThan(roadsideAssistancePrice);
    }
}