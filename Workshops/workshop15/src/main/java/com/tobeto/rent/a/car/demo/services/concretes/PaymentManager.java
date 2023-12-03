package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Payment;
import com.tobeto.rent.a.car.demo.repositories.PaymentRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.PaymentService;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.AddPaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.requests.UpdatePaymentRequest;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetAllPaymentsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetListPaymentResponse;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetPaymentResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public GetPaymentResponse getById(int id) {
        Payment paymentToId = paymentRepository.findById(id).orElseThrow();
        GetPaymentResponse getPaymentResponse = new GetPaymentResponse();
        getPaymentResponse.setDailyPrice(paymentToId.getDailyPrice());
        getPaymentResponse.setWeeklyPrice(paymentToId.getWeeklyPrice());
        getPaymentResponse.setMonthlyPrice(paymentToId.getMonthlyPrice());
        getPaymentResponse.setCustomerId(paymentToId.getCustomer());
        return getPaymentResponse;
    }

    @Override
    public List<GetAllPaymentsResponse> getAll() {
        List<Payment> paymentList = paymentRepository.findAll();
        List<GetAllPaymentsResponse> getAllPaymentsResponseList = new ArrayList<>();
        for (Payment payment : paymentList) {
            GetAllPaymentsResponse getAllPaymentsResponse = new GetAllPaymentsResponse();
            getAllPaymentsResponse.setId(payment.getId());
            getAllPaymentsResponse.setDailyPrice(payment.getDailyPrice());
            getAllPaymentsResponse.setWeeklyPrice(payment.getWeeklyPrice());
            getAllPaymentsResponse.setMonthlyPrice(payment.getMonthlyPrice());
            getAllPaymentsResponse.setCustomerId(payment.getCustomer());
            getAllPaymentsResponseList.add(getAllPaymentsResponse);
        }
        return getAllPaymentsResponseList;
    }

    @Override
    public List<Payment> getByDailyPriceGreaterThan(double dailyPrice) {
        return paymentRepository.findByDailyPriceGreaterThan(dailyPrice);
    }

    @Override
    public List<Payment> getByOrderByWeeklyPrice() {
        return paymentRepository.findByOrderByWeeklyPrice();
    }

    @Override
    public List<Payment> getDistinctByMonthlyPrice(double monthlyPrice) {
        return paymentRepository.findDistinctByMonthlyPrice(monthlyPrice);
    }

    @Override
    public List<GetListPaymentResponse> getByMonthlyPrice(double monthlyPrice) {
        return paymentRepository.findByMonthlyPrice(monthlyPrice);
    }
}