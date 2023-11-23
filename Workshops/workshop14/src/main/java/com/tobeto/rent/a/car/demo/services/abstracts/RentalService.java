package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rent.a.car.demo.services.dtos.rental.requests.UpdateRentalRequest;

public interface RentalService {

    void add(AddRentalRequest addRentalRequest);

    void delete(int id);

    void update(UpdateRentalRequest updateRentalRequest);
}
