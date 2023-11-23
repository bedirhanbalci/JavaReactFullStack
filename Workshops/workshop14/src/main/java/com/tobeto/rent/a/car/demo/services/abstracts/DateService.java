package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.date.requests.AddDateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.date.requests.UpdateDateRequest;

public interface DateService {

    void add(AddDateRequest addDateRequest);

    void delete(int id);

    void update(UpdateDateRequest updateDateRequest);
}
