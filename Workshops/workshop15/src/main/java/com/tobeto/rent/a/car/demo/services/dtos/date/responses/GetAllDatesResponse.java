package com.tobeto.rent.a.car.demo.services.dtos.date.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetAllDatesResponse {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate extendDate;
}
