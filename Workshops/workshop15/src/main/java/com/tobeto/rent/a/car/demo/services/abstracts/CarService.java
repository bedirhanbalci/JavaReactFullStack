package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetCarResponse;

import java.util.List;

public interface CarService {


    void add(AddCarRequest addCarRequest);

    void delete(int id);

    void update(UpdateCarRequest updateCarRequest);

    GetCarResponse getById(int id);

    List<GetAllCarsResponse> getAll();
}
