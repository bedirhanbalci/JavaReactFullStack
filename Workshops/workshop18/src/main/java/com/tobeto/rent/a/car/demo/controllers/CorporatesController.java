package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Corporate;
import com.tobeto.rent.a.car.demo.services.abstracts.CorporateService;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.AddCorporateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.UpdateCorporateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetAllCorporatesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetCorporateResponse;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetListCorporateResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/corporates")
@AllArgsConstructor
public class CorporatesController {

    private final CorporateService corporateService;

    @PostMapping
    public void add(@RequestBody @Valid AddCorporateRequest addCorporateRequest) {
        corporateService.add(addCorporateRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        corporateService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCorporateRequest updateCorporateRequest) {
        corporateService.update(updateCorporateRequest);
    }

    @GetMapping("{id}")
    public GetCorporateResponse getById(@PathVariable int id) {
        return corporateService.getById(id);
    }

    @GetMapping("all")
    public List<GetAllCorporatesResponse> getAll() {
        return corporateService.getAll();
    }

    @GetMapping("companyName")
    public List<Corporate> getByCompanyName(@RequestParam String companyName) {
        return corporateService.getByCompanyName(companyName);
    }

    @GetMapping("iLike")
    public List<GetListCorporateResponse> getByContactTitleILike() {
        return corporateService.getByContactTitleILike();
    }

    @GetMapping("and")
    public List<GetListCorporateResponse> getByCompanyNameAndContactTitle() {
        return corporateService.getByCompanyNameAndContactTitle();
    }

    @GetMapping("orderBy")
    public List<GetListCorporateResponse> getOrderByContactName() {
        return corporateService.getOrderByContactName();
    }
}