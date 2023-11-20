package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Location;
import com.tobeto.rent.a.car.demo.repositories.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api(locations")
public class LocationsController {

    private final LocationRepository locationRepository;

    public LocationsController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping
    public List<Location> getAll() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }

    @GetMapping("{id}")
    public Location getById(@PathVariable int id) {
        return locationRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Location location) {
        locationRepository.save(location);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Location locationToDelete = locationRepository.findById(id).orElseThrow();
        locationRepository.delete(locationToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Location location) {
        Location locationToUpdate = locationRepository.findById(id).orElseThrow();
        locationToUpdate.setPickUpLocation(location.getPickUpLocation());
        locationToUpdate.setDropOffLocation(location.getDropOffLocation());
        locationRepository.save(locationToUpdate);
    }
}
