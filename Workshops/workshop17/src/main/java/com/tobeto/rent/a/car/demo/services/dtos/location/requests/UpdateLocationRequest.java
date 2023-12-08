package com.tobeto.rent.a.car.demo.services.dtos.location.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLocationRequest {

    @Positive(message = "Doğru konum id girişi yapınız!")
    private int id;

    @NotBlank(message = "Teslim alma konumu boş geçilemez!")
    private String pickUpLocation;

    @NotBlank(message = "Teslim etme konumu boş geçilemez!")
    private String dropOffLocation;
}
