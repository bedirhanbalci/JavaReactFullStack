package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.location.requests.AddLocationRequest;
import com.tobeto.rent.a.car.demo.services.dtos.location.requests.UpdateLocationRequest;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetAllLocationsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetLocationResponse;

import java.util.List;

public interface LocationService {

    void add(AddLocationRequest addLocationRequest);

    void delete(int id);

    void update(UpdateLocationRequest updateLocationRequest);

    GetLocationResponse getById(int id);

    List<GetAllLocationsResponse> getAll();
}
