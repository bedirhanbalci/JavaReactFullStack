package com.tobeto.rent.a.car.demo.services.dtos.date.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListDateResponse {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate extendDate;
}
