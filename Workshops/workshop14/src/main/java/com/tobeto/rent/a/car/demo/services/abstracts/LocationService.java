package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.location.requests.AddLocationRequest;
import com.tobeto.rent.a.car.demo.services.dtos.location.requests.UpdateLocationRequest;

public interface LocationService {

    void add(AddLocationRequest addLocationRequest);

    void delete(int id);

    void update(UpdateLocationRequest updateLocationRequest);
}
