package com.tobeto.rent.a.car.demo.services.abstracts;


import com.tobeto.rent.a.car.demo.entities.Payment;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetAllPaymentsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetListPaymentResponse;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetPaymentResponse;

import java.util.List;

public interface PaymentService {

    void add(AddPaymentRequest addPaymentRequest);

    void delete(int id);

    void update(UpdatePaymentRequest updatePaymentRequest);

    GetPaymentResponse getById(int id);

    List<GetAllPaymentsResponse> getAll();

    List<Payment> getByDailyPriceGreaterThan(double dailyPrice);

    List<Payment> getByOrderByWeeklyPrice();

    List<Payment> getDistinctByMonthlyPrice(double monthlyPrice);

    List<GetListPaymentResponse> getByMonthlyPrice(double monthlyPrice);


}
