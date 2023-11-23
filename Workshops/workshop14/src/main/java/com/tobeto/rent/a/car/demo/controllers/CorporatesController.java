package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.CorporateService;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.AddCorporateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.UpdateCorporateRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/corporates")
public class CorporatesController {

    private final CorporateService corporateService;

    public CorporatesController(CorporateService corporateService) {
        this.corporateService = corporateService;
    }

    @PostMapping
    public void add(@RequestBody AddCorporateRequest addCorporateRequest) {
        corporateService.add(addCorporateRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        corporateService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateCorporateRequest updateCorporateRequest) {
        corporateService.update(updateCorporateRequest);
    }
}