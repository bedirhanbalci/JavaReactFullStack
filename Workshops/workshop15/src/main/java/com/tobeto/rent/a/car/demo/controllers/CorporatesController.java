package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.CorporateService;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.AddCorporateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.UpdateCorporateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetAllCorporatesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetCorporateResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public GetCorporateResponse getById(@PathVariable int id) {
        return corporateService.getById(id);
    }

    @GetMapping
    public List<GetAllCorporatesResponse> getAll() {
        return corporateService.getAll();
    }
}