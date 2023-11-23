package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.AddCorporateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.UpdateCorporateRequest;

public interface CorporateService {

    void add(AddCorporateRequest addCorporateRequest);

    void delete(int id);

    void update(UpdateCorporateRequest updateCorporateRequest);
}
