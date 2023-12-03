package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Individual;
import com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetListIndividualResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndividualRepository extends JpaRepository<Individual, Integer> {

    List<Individual> findByNameStartingWith(String name);

    List<Individual> findBySurnameStartingWith(String surname);

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetListIndividualResponse (i.id, i.name, i.surname, i.birthDate, i.gender, i.customer)" +
            "FROM Individual i WHERE i.gender = 'Male'")
    List<GetListIndividualResponse> findByGender();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.individual.responses.GetListIndividualResponse(i.id, i.name, i.surname, i.birthDate, i.gender, i.customer)" +
            "FROM Individual i ORDER BY i.birthDate ASC")
    List<GetListIndividualResponse> findOrderByBirthDate();

}
