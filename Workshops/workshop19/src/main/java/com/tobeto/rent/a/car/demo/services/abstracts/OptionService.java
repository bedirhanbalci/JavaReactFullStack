package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.entities.Option;
import com.tobeto.rent.a.car.demo.services.dtos.option.requests.AddOptionRequest;
import com.tobeto.rent.a.car.demo.services.dtos.option.requests.UpdateOptionRequest;
import com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetAllOptionsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetListOptionResponse;
import com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetOptionResponse;

import java.util.List;

public interface OptionService {

    void add(AddOptionRequest addOptionRequest);

    void delete(int id);

    void update(UpdateOptionRequest updateOptionRequest);

    GetOptionResponse getById(int id);

    List<GetAllOptionsResponse> getAll();

    List<Option> getByOrderByRentalCancellationPriceDesc();

    List<GetListOptionResponse> getByDriverPriceGreaterThanEqual(double additionalDriverPrice);

    List<GetListOptionResponse> getByAssistancePriceLessThan(double roadsideAssistancePrice);
}