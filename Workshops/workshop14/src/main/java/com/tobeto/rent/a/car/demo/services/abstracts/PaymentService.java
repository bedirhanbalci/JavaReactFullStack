package com.tobeto.rent.a.car.demo.services.abstracts;


import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetAllPaymentsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetPaymentResponse;

import java.util.List;

public interface PaymentService {

    void add(AddPaymentRequest addPaymentRequest);

    void delete(int id);

    void update(UpdatePaymentRequest updatePaymentRequest);

    GetPaymentResponse getById(int id);

    List<GetAllPaymentsResponse> getAll();
}
