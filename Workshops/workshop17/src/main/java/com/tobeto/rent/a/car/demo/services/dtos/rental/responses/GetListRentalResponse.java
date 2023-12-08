package com.tobeto.rent.a.car.demo.services.dtos.rental.responses;

import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetListCarResponse;
import com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse;
import com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetListDateResponse;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetListLocationResponse;
import com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetListPaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentalResponse {
    private int id;
    private GetListPaymentResponse payment;
    private GetListCustomerResponse customer;
    private GetListCarResponse car;
    private GetListDateResponse date;
    private GetListLocationResponse location;
    private String reservation;
}
