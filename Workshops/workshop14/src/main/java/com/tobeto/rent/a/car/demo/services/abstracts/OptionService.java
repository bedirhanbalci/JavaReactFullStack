package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.option.requests.AddOptionRequest;
import com.tobeto.rent.a.car.demo.services.dtos.option.requests.UpdateOptionRequest;

public interface OptionService {

    void add(AddOptionRequest addOptionRequest);

    void delete(int id);

    void update(UpdateOptionRequest updateOptionRequest);
}