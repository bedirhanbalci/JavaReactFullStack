package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Price;
import com.tobeto.rent.a.car.demo.repositories.PriceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/prices")
public class PricesController {

    private final PriceRepository priceRepository;

    public PricesController(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @GetMapping
    public List<Price> getAll() {
        List<Price> prices = priceRepository.findAll();
        return prices;
    }

    @GetMapping("{id}")
    public Price getById(@PathVariable int id) {
        return priceRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Price price) {
        priceRepository.save(price);
    }

    @DeleteMapping("{id}")
    public void elete(@PathVariable int id) {
        Price priceToDelete = priceRepository.findById(id).orElseThrow();
        priceRepository.delete(priceToDelete);
    }


    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Price price) {
        Price priceToUpdate = priceRepository.findById(id).orElseThrow();
        priceToUpdate.setOption(price.getOption());
        priceToUpdate.setPayment(price.getPayment());
        priceRepository.save(priceToUpdate);
    }
}