package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Price;
import com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetListPriceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {

    List<Price> findByOrderByOptionId();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetListPriceResponse" +
            " (p.id, new com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetListOptionResponse(o.id, o.rentalCancellationPrice, o.additionalDriverPrice, o.roadsideAssistancePrice), " +
            "new com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetListPaymentResponse(pay.id, pay.dailyPrice, pay.weeklyPrice, pay.monthlyPrice," +
            "new com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse(c.id, c.phone, c.email, c.address)))" +
            "FROM Price p" +
            " INNER JOIN p.option o" +
            " INNER JOIN p.payment pay" +
            " INNER JOIN pay.customer c" +
            "  ORDER BY pay.id ")
    List<GetListPriceResponse> findByOrderByPaymentId();

}
