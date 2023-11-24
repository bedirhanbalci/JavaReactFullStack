package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.AddCorporateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.UpdateCorporateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetAllCorporatesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetCorporateResponse;

import java.util.List;

public interface CorporateService {

    void add(AddCorporateRequest addCorporateRequest);

    void delete(int id);

    void update(UpdateCorporateRequest updateCorporateRequest);

    GetCorporateResponse getById(int id);

    List<GetAllCorporatesResponse> getAll();
}
