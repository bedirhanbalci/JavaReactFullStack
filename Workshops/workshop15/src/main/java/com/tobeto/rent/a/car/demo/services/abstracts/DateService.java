package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.date.requests.AddDateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.date.requests.UpdateDateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetAllDatesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetDateResponse;

import java.util.List;

public interface DateService {

    void add(AddDateRequest addDateRequest);

    void delete(int id);

    void update(UpdateDateRequest updateDateRequest);

    GetDateResponse getById(int id);

    List<GetAllDatesResponse> getAll();
}
