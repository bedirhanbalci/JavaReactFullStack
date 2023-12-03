package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Price;
import com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetListPriceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {

    List<Price> findByOrderByOptionId();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetListPriceResponse (p.id, p.option, p.payment)" +
            "FROM Price p" +
            " JOIN p.payment pe" +
            "  ORDER BY pe.id ")
    List<GetListPriceResponse> findByOrderByPaymentId();

}
