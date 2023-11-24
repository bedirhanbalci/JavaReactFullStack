package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Car;
import com.tobeto.rent.a.car.demo.repositories.CarRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.CarService;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetCarResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public GetCarResponse getById(int id) {
        Car carToId = carRepository.findById(id).orElseThrow();
        GetCarResponse getCarResponse = new GetCarResponse();
        getCarResponse.setBrand(carToId.getBrand());
        getCarResponse.setModel(carToId.getModel());
        getCarResponse.setYear(carToId.getYear());
        getCarResponse.setColor(carToId.getColor());
        getCarResponse.setStatus(carToId.getStatus());
        getCarResponse.setCategoryId(carToId.getCategory());
        return getCarResponse;
    }

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> carList = carRepository.findAll();
        List<GetAllCarsResponse> getAllCarsResponseList = new ArrayList<>();
        for (Car car : carList) {
            GetAllCarsResponse getAllCarsResponse = new GetAllCarsResponse();
            getAllCarsResponse.setId(car.getId());
            getAllCarsResponse.setBrand(car.getBrand());
            getAllCarsResponse.setModel(car.getModel());
            getAllCarsResponse.setYear(car.getYear());
            getAllCarsResponse.setColor(car.getColor());
            getAllCarsResponse.setStatus(car.getStatus());
            getAllCarsResponse.setCategoryId(car.getCategory());
            getAllCarsResponseList.add(getAllCarsResponse);
        }
        return getAllCarsResponseList;
    }
}
