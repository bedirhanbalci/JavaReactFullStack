package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rent.a.car.demo.services.dtos.price.requests.UpdatePriceRequest;

public interface PriceService {

    void add(AddPriceRequest addPriceRequest);

    void delete(int id);

    void update(UpdatePriceRequest updatePriceRequest);
}
