package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Individual;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetListIndividualResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndividualRepository extends JpaRepository<Individual, Integer> {

    List<Individual> findByNameStartingWith(String name);

    List<Individual> findBySurnameStartingWith(String surname);

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetListIndividualResponse" +
            " (i.id, i.name, i.surname, i.birthDate, i.gender, new com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse(c.id, c.phone, c.email, c.address))" +
            "FROM Individual i INNER JOIN i.customer c WHERE i.gender = 'Male'")
    List<GetListIndividualResponse> findByGender();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetListIndividualResponse" +
            "(i.id, i.name, i.surname, i.birthDate, i.gender, new com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse(c.id, c.phone, c.email, c.address))" +
            "FROM Individual i INNER JOIN i.customer c ORDER BY i.birthDate ASC")
    List<GetListIndividualResponse> findByOrderByBirthDate();

    boolean existsIndividualByIdentificationNumber(String identificationNumber);
}
