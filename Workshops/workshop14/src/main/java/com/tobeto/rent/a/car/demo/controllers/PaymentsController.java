package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.PaymentService;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetAllPaymentsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetPaymentResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
    private final PaymentService paymentService;

    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public void add(@RequestBody AddPaymentRequest addPaymentRequest) {
        paymentService.add(addPaymentRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        paymentService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdatePaymentRequest updatePaymentRequest) {
        paymentService.update(updatePaymentRequest);
    }

    @GetMapping("{id}")
    public GetPaymentResponse getById(@PathVariable int id) {
        return paymentService.getById(id);
    }

    @GetMapping
    public List<GetAllPaymentsResponse> getAll() {
        return paymentService.getAll();
    }
}