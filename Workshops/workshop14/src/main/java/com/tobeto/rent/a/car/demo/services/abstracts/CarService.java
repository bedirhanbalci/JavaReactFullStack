package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.UpdateCarRequest;

public interface CarService {
    void add(AddCarRequest addCarRequest);

    void delete(int id);

    void update(UpdateCarRequest updateCarRequest);
}