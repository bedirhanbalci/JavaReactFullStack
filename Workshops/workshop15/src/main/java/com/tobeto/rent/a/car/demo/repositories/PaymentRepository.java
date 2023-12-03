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

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetListPaymentResponse (p.id, p.dailyPrice, p.weeklyPrice, p.monthlyPrice, p.customer)" +
            "FROM Payment p WHERE p.monthlyPrice = :monthlyPrice")
    List<GetListPaymentResponse> findByMonthlyPrice(double monthlyPrice);


}
