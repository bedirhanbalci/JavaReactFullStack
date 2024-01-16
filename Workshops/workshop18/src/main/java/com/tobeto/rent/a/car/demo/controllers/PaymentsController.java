package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Payment;
import com.tobeto.rent.a.car.demo.services.abstracts.PaymentService;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetAllPaymentsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetListPaymentResponse;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetPaymentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
@AllArgsConstructor
public class PaymentsController {
    private final PaymentService paymentService;

    @PostMapping
    public void add(@RequestBody @Valid AddPaymentRequest addPaymentRequest) {
        paymentService.add(addPaymentRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        paymentService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdatePaymentRequest updatePaymentRequest) {
        paymentService.update(updatePaymentRequest);
    }

    @GetMapping("{id}")
    public GetPaymentResponse getById(@PathVariable int id) {
        return paymentService.getById(id);
    }

    @GetMapping("all")
    public List<GetAllPaymentsResponse> getAll() {
        return paymentService.getAll();
    }

    @GetMapping("dailyGreater")
    public List<Payment> getByDailyPriceGreaterThan(@RequestParam double dailyPrice) {
        return paymentService.getByDailyPriceGreaterThan(dailyPrice);
    }

    @GetMapping("orderByWeekly")
    public List<Payment> getByOrderByWeeklyPrice() {
        return paymentService.getByOrderByWeeklyPrice();
    }

    @GetMapping("distinctMonthly")
    public List<Payment> getDistinctByMonthlyPrice(@RequestParam double monthlyPrice) {
        return paymentService.getDistinctByMonthlyPrice(monthlyPrice);
    }

    @GetMapping("monthly")
    public List<GetListPaymentResponse> getByMonthlyPrice(@RequestParam double monthlyPrice) {
        return paymentService.getByMonthlyPrice(monthlyPrice);
    }
}