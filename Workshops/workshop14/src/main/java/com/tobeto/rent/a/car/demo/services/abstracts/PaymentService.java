package com.tobeto.rent.a.car.demo.services.abstracts;


import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.UpdatePaymentRequest;

public interface PaymentService {

    void add(AddPaymentRequest addPaymentRequest);

    void delete(int id);

    void update(UpdatePaymentRequest updatePaymentRequest);
}
