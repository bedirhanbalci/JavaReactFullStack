package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.entities.Rental;
import com.tobeto.rent.a.car.demo.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rent.a.car.demo.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.rent.a.car.demo.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.rental.responses.GetListRentalResponse;
import com.tobeto.rent.a.car.demo.services.dtos.rental.responses.GetRentalResponse;

import java.util.List;

public interface RentalService {

    void add(AddRentalRequest addRentalRequest);

    void delete(int id);

    void update(UpdateRentalRequest updateRentalRequest);

    GetRentalResponse getById(int id);

    List<GetAllRentalsResponse> getAll();

    List<Rental> getByOrderByPaymentId();

    List<GetListRentalResponse> getByReservationOrderByCustomerId();
}
