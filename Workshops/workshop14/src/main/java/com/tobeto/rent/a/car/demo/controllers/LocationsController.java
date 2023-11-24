package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.LocationService;
import com.tobeto.rent.a.car.demo.services.dtos.location.requests.AddLocationRequest;
import com.tobeto.rent.a.car.demo.services.dtos.location.requests.UpdateLocationRequest;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetAllLocationsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetLocationResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api(locations")
public class LocationsController {
    private final LocationService locationService;

    public LocationsController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public void add(@RequestBody AddLocationRequest addLocationRequest) {
        locationService.add(addLocationRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        locationService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateLocationRequest updateLocationRequest) {
        locationService.update(updateLocationRequest);
    }

    @GetMapping("{id}")
    public GetLocationResponse getById(@PathVariable int id) {
        return locationService.getById(id);
    }

    @GetMapping
    public List<GetAllLocationsResponse> getAll() {
        return locationService.getAll();
    }
}