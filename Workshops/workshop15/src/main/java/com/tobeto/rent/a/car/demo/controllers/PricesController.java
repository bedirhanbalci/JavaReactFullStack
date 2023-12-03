package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Price;
import com.tobeto.rent.a.car.demo.services.abstracts.PriceService;
import com.tobeto.rent.a.car.demo.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rent.a.car.demo.services.dtos.price.requests.UpdatePriceRequest;
import com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetAllPricesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetListPriceResponse;
import com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetPriceResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public GetPriceResponse getById(@PathVariable int id) {
        return priceService.getById(id);
    }

    @GetMapping("all")
    public List<GetAllPricesResponse> getAll() {
        return priceService.getAll();
    }

    @GetMapping("orderByOption")
    public List<Price> getByOrderByOptionId() {
        return priceService.getByOrderByOptionId();
    }

    @GetMapping("orderByPayment")
    public List<GetListPriceResponse> getByOrderByPaymentId() {
        return priceService.getByOrderByPaymentId();
    }
}