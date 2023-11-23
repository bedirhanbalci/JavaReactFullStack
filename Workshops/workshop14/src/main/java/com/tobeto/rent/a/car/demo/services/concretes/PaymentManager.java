package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Payment;
import com.tobeto.rent.a.car.demo.repositories.PaymentRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.PaymentService;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.UpdatePaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentManager implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentManager(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void add(AddPaymentRequest addPaymentRequest) {
        Payment payment = new Payment();
        payment.setDailyPrice(addPaymentRequest.getDailyPrice());
        payment.setWeeklyPrice(addPaymentRequest.getWeeklyPrice());
        payment.setMonthlyPrice(addPaymentRequest.getMonthlyPrice());
        payment.setAssurancePrice(addPaymentRequest.getAssurancePrice());
        payment.setFuelPrice(addPaymentRequest.getFuelPrice());
        payment.setCustomer(addPaymentRequest.getCustomerId());
        paymentRepository.save(payment);
    }

    @Override
    public void delete(int id) {
        Payment paymentToDelete = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    @Override
    public void update(UpdatePaymentRequest updatePaymentRequest) {
        Payment paymentToUpdate = paymentRepository.findById(updatePaymentRequest.getId()).orElseThrow();
        paymentToUpdate.setDailyPrice(updatePaymentRequest.getDailyPrice());
        paymentToUpdate.setWeeklyPrice(updatePaymentRequest.getWeeklyPrice());
        paymentToUpdate.setMonthlyPrice(updatePaymentRequest.getMonthlyPrice());
        paymentToUpdate.setCustomer(updatePaymentRequest.getCustomerId());
        paymentRepository.save(paymentToUpdate);
    }
}