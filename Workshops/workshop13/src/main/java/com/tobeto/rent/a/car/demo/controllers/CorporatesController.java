package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Corporate;
import com.tobeto.rent.a.car.demo.repositories.CorporateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/corporates")
public class CorporatesController {

    private final CorporateRepository corporateRepository;

    public CorporatesController(CorporateRepository corporateRepository) {
        this.corporateRepository = corporateRepository;
    }

    @GetMapping
    public List<Corporate> getAll() {
        List<Corporate> corporates = corporateRepository.findAll();
        return corporates;
    }

    @GetMapping("{id}")
    public Corporate getById(@PathVariable int id) {
        return corporateRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Corporate corporate) {
        corporateRepository.save(corporate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Corporate corporateToDelete = corporateRepository.findById(id).orElseThrow();
        corporateRepository.delete(corporateToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Corporate corporate) {
        Corporate corporateToUpdate = corporateRepository.findById(id).orElseThrow();
        corporateToUpdate.setCompanyName(corporate.getCompanyName());
        corporateToUpdate.setContactName(corporate.getContactName());
        corporateToUpdate.setContactTitle(corporate.getContactTitle());
        corporateToUpdate.setTaxNumber(corporate.getTaxNumber());
        corporateToUpdate.setCustomer(corporate.getCustomer());
        corporateRepository.save(corporateToUpdate);
    }
}
