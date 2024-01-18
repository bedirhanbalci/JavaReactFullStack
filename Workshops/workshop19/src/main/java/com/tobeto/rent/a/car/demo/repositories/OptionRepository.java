package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Option;
import com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetListOptionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Integer> {

    List<Option> findByOrderByRentalCancellationPriceDesc();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetListOptionResponse (o.id, o.rentalCancellationPrice, o.additionalDriverPrice, o.roadsideAssistancePrice)" +
            "FROM Option o WHERE o.additionalDriverPrice >= :additionalDriverPrice")
    List<GetListOptionResponse> findByAdditionalDriverPriceGreaterThanEqual(double additionalDriverPrice);

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetListOptionResponse (o.id, o.rentalCancellationPrice, o.additionalDriverPrice, o.roadsideAssistancePrice)" +
            "FROM Option o WHERE o.roadsideAssistancePrice < :roadsideAssistancePrice")
    List<GetListOptionResponse> findByRoadsideAssistancePriceLessThan(double roadsideAssistancePrice);

}
