package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Location;
import com.tobeto.rent.a.car.demo.services.abstracts.LocationService;
import com.tobeto.rent.a.car.demo.services.dtos.location.requests.AddLocationRequest;
import com.tobeto.rent.a.car.demo.services.dtos.location.requests.UpdateLocationRequest;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetAllLocationsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetListLocationResponse;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetLocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api(locations")
@AllArgsConstructor
public class LocationsController {
    private final LocationService locationService;

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

    @GetMapping("all")
    public List<GetAllLocationsResponse> getAll() {
        return locationService.getAll();
    }

    @GetMapping("pickUp")
    public List<Location> getByPickUp(@RequestParam String pickUpLocation) {
        return locationService.getByPickUp(pickUpLocation);
    }

    @GetMapping("dropOff")
    public List<Location> getByDropOff(@RequestParam String dropOffLocation) {
        return locationService.getByDropOff(dropOffLocation);
    }

    @GetMapping("pickOrDrop")
    public List<GetListLocationResponse> getByPickUpOrDropOff() {
        return locationService.getByPickUpOrDropOff();
    }

    @GetMapping("pickILike")
    public List<GetListLocationResponse> getByPickUpILike() {
        return locationService.getByPickUpILike();
    }

    @GetMapping("pickOrder")
    public List<GetListLocationResponse> getByOrderByPickUp() {
        return locationService.getByOrderByPickUp();
    }
}