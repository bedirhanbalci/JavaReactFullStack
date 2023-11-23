package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.AddIndividualRequest;
import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.UpdateIndividualRequest;

public interface IndividualService {

    void add(AddIndividualRequest addIndividualRequest);

    void delete(int id);

    void update(UpdateIndividualRequest updateIndividualRequest);
}
