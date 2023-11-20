package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Payment;
import com.tobeto.rent.a.car.demo.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {

    private final PaymentRepository paymentRepository;

    public PaymentsController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public List<Payment> getAll() {
        List<Payment> payments = paymentRepository.findAll();
        return payments;
    }

    @GetMapping("{id}")
    public Payment getById(@PathVariable int id) {
        return paymentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Payment payment) {
        paymentRepository.save(payment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Payment paymentToDelete = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Payment payment) {
        Payment paymentToUpdate = paymentRepository.findById(id).orElseThrow();
        paymentToUpdate.setDailyPrice(payment.getDailyPrice());
        paymentToUpdate.setWeeklyPrice(payment.getWeeklyPrice());
        paymentToUpdate.setMonthlyPrice(payment.getMonthlyPrice());
        paymentToUpdate.setAssurancePrice(payment.getAssurancePrice());
        paymentToUpdate.setFuelPrice(payment.getFuelPrice());
        paymentToUpdate.setCustomer(payment.getCustomer());
        paymentRepository.save(paymentToUpdate);
    }
}