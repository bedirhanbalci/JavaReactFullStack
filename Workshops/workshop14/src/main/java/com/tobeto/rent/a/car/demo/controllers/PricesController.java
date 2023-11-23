package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.PriceService;
import com.tobeto.rent.a.car.demo.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rent.a.car.demo.services.dtos.price.requests.UpdatePriceRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/prices")
public class PricesController {
    private final PriceService priceService;

    public PricesController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping
    public void add(@RequestBody AddPriceRequest addPriceRequest) {
        priceService.add(addPriceRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        priceService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdatePriceRequest updatePriceRequest) {
        priceService.update(updatePriceRequest);
    }
}