package com.tobeto.rent.a.car.demo.services.dtos.date.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDateRequest {

    @NotNull(message = "Başlangıç tarihi boş olamaz!")
    private LocalDate startDate;

    @NotNull(message = "Bitiş Tarihi seçmelisiniz!")
    private LocalDate endDate;

    private LocalDate extendDate;
}
