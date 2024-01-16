package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Individual;
import com.tobeto.rent.a.car.demo.repositories.IndividualRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.IndividualService;
import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.AddIndividualRequest;
import com.tobeto.rent.a.car.demo.services.dtos.individual.requests.UpdateIndividualRequest;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetAllIndividualsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetIndividualResponse;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetListIndividualResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class IndividualManager implements IndividualService {

    private final IndividualRepository individualRepository;

    @Override
    public void add(AddIndividualRequest addIndividualRequest) {


        if (individualRepository.existsIndividualByIdentificationNumber(addIndividualRequest.getIdentificationNumber())) {
            throw new RuntimeException("Aynı ulusal kimlik numarası daha önce de eklendi.");
        }


        if (!Character.isUpperCase(addIndividualRequest.getName().charAt(0))) {
            throw new RuntimeException("Bireysel müşteri isminin ilk harfi büyük olmalıdır.");
        }


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

        if (!Character.isUpperCase(updateIndividualRequest.getName().charAt(0))) {
            throw new RuntimeException("Bireysel müşteri isminin ilk harfi büyük olmalıdır.");
        }

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

    @Override
    public List<Individual> getByName(String name) {
        return individualRepository.findByNameStartingWith(name);
    }

    @Override
    public List<Individual> getBySurname(String surname) {
        return individualRepository.findBySurnameStartingWith(surname);
    }

    @Override
    public List<GetListIndividualResponse> getByGender() {
//        return individualRepository.findByGender();

        return individualRepository.findByGender().stream().map((individual) -> {
            return new GetListIndividualResponse(individual.getId(), individual.getName(), individual.getSurname(), individual.getBirthDate(), individual.getGender(), individual.getCustomer());
        }).toList();
    }

    @Override
    public List<GetListIndividualResponse> getByOrderByBirthDate() {
//        return individualRepository.findOrderByBirthDate();

        return individualRepository.findByOrderByBirthDate().stream().map((individual) -> {
            return new GetListIndividualResponse(individual.getId(), individual.getName(), individual.getSurname(), individual.getBirthDate(), individual.getGender(), individual.getCustomer());
        }).toList();
    }
}