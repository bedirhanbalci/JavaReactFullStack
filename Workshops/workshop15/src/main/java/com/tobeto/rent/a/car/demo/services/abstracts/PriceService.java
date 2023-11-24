package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rent.a.car.demo.services.dtos.price.requests.UpdatePriceRequest;
import com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetAllPricesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetPriceResponse;

import java.util.List;

public interface PriceService {

    void add(AddPriceRequest addPriceRequest);

    void delete(int id);

    void update(UpdatePriceRequest updatePriceRequest);

    GetPriceResponse getById(int id);

    List<GetAllPricesResponse> getAll();
}
