package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Payment;
import com.tobeto.rent.a.car.demo.services.dtos.option.responses.GetListOptionResponse;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetListPaymentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByDailyPriceGreaterThan(double dailyPrice);

    List<Payment> findByOrderByWeeklyPrice();

    List<Payment> findDistinctByMonthlyPrice(double monthlyPrice);

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetListPaymentResponse" +
            " (p.id, p.dailyPrice, p.weeklyPrice, p.monthlyPrice, new com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse(c.id, c.phone, c.email, c.address))" +
            "FROM Payment p INNER JOIN p.customer c WHERE p.monthlyPrice = :monthlyPrice")
    List<GetListPaymentResponse> findByMonthlyPrice(double monthlyPrice);

}
