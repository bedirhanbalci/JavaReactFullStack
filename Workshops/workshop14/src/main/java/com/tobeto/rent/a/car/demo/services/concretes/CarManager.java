package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Car;
import com.tobeto.rent.a.car.demo.repositories.CarRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.CarService;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.UpdateCarRequest;
import org.springframework.stereotype.Service;

@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void add(AddCarRequest addCarRequest) {
        Car car = new Car();
        car.setBrand(addCarRequest.getBrand());
        car.setModel(addCarRequest.getModel());
        car.setYear(addCarRequest.getYear());
        car.setColor(addCarRequest.getColor());
        car.setStatus(addCarRequest.getStatus());
        car.setNumberPlate(addCarRequest.getNumberPlate());
        car.setCategory(addCarRequest.getCategoryId());
        carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car carToUpdate = carRepository.findById(updateCarRequest.getId()).orElseThrow();
        carToUpdate.setBrand(updateCarRequest.getBrand());
        carToUpdate.setModel(updateCarRequest.getModel());
        carToUpdate.setYear(updateCarRequest.getYear());
        carToUpdate.setColor(updateCarRequest.getColor());
        carToUpdate.setStatus(updateCarRequest.getStatus());
        carToUpdate.setCategory(updateCarRequest.getCategoryId());
        carRepository.save(carToUpdate);
    }
}