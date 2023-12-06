package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Car;
import com.tobeto.rent.a.car.demo.services.abstracts.CarService;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetCarResponse;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {
    private final CarService carService;

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

    @GetMapping("all")
    public List<GetAllCarsResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("brand")
    public List<Car> getByBrand(@RequestParam String brand) {
        return carService.getByBrand(brand);
    }

    @GetMapping("status")
    public List<GetListCarResponse> getByStatus() {
        return carService.getByStatus();
    }

    @GetMapping("year")
    public List<GetListCarResponse> getOrderByYear() {
        return carService.getOrderByYear();
    }

    @GetMapping("brandAndColor")
    public List<GetListCarResponse> getByBrandAndColor() {
        return carService.getByBrandAndColor();
    }
}
