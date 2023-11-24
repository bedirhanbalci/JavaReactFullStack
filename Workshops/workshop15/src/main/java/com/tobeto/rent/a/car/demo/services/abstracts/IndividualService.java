package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.AddIndividualRequest;
import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.UpdateIndividualRequest;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetAllIndividualsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetIndividualResponse;

import java.util.List;

public interface IndividualService {

    void add(AddIndividualRequest addIndividualRequest);

    void delete(int id);

    void update(UpdateIndividualRequest updateIndividualRequest);

    GetIndividualResponse getById(int id);

    List<GetAllIndividualsResponse> getAll();
}