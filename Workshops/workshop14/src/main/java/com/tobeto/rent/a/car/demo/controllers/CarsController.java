package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.CarService;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetCarResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest addCarRequest) {
        carService.add(addCarRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateCarRequest updateCarRequest) {
        carService.update(updateCarRequest);
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id) {
        return carService.getById(id);
    }

    @GetMapping
    public List<GetAllCarsResponse> getAll() {
        return carService.getAll();
    }
}
