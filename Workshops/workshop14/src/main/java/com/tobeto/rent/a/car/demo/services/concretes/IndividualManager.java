package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Individual;
import com.tobeto.rent.a.car.demo.repositories.IndividualRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.IndividualService;
import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.AddIndividualRequest;
import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.UpdateIndividualRequest;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetAllIndividualsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetIndividualResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndividualManager implements IndividualService {

    private final IndividualRepository individualRepository;

    public IndividualManager(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }

    @Override
    public void add(AddIndividualRequest addIndividualRequest) {
        Individual individual = new Individual();
        individual.setName(addIndividualRequest.getName());
        individual.setSurname(addIndividualRequest.getSurname());
        individual.setBirthDate(addIndividualRequest.getBirthDate());
        individual.setGender(addIndividualRequest.getGender());
        individual.setIdentificationNumber(addIndividualRequest.getIdentificationNumber());
        individual.setCustomer(addIndividualRequest.getCustomerId());
        individualRepository.save(individual);
    }

    @Override
    public void delete(int id) {
        Individual individualToDelete = individualRepository.findById(id).orElseThrow();
        individualRepository.delete(individualToDelete);
    }

    @Override
    public void update(UpdateIndividualRequest updateIndividualRequest) {
        Individual individualToUpdate = individualRepository.findById(updateIndividualRequest.getId()).orElseThrow();
        individualToUpdate.setName(updateIndividualRequest.getName());
        individualToUpdate.setSurname(updateIndividualRequest.getSurname());
        individualToUpdate.setBirthDate(updateIndividualRequest.getBirthDate());
        individualToUpdate.setGender(updateIndividualRequest.getGender());
        individualToUpdate.setCustomer(updateIndividualRequest.getCustomerId());
        individualRepository.save(individualToUpdate);
    }

    @Override
    public GetIndividualResponse getById(int id) {
        Individual individualToId = individualRepository.findById(id).orElseThrow();
        GetIndividualResponse getIndividualResponse = new GetIndividualResponse();
        getIndividualResponse.setName(individualToId.getName());
        getIndividualResponse.setSurname(individualToId.getSurname());
        getIndividualResponse.setBirthDate(individualToId.getBirthDate());
        getIndividualResponse.setGender(individualToId.getGender());
        getIndividualResponse.setCustomerId(individualToId.getCustomer());
        return getIndividualResponse;
    }

    @Override
    public List<GetAllIndividualsResponse> getAll() {
        List<Individual> individualList = individualRepository.findAll();
        List<GetAllIndividualsResponse> getAllIndividualsResponseList = new ArrayList<>();
        for (Individual individual : individualList) {
            GetAllIndividualsResponse getAllIndividualsResponse = new GetAllIndividualsResponse();
            getAllIndividualsResponse.setId(individual.getId());
            getAllIndividualsResponse.setName(individual.getName());
            getAllIndividualsResponse.setSurname(individual.getSurname());
            getAllIndividualsResponse.setBirthDate(individual.getBirthDate());
            getAllIndividualsResponse.setGender(individual.getGender());
            getAllIndividualsResponse.setCustomerId(individual.getCustomer());
            getAllIndividualsResponseList.add(getAllIndividualsResponse);
        }
        return getAllIndividualsResponseList;
    }
}