package com.tobeto.rent.a.car.demo.services.dtos.date.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddDateRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate extendDate;
}
