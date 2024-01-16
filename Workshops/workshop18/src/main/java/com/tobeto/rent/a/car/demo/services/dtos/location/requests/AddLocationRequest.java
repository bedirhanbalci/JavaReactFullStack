package com.tobeto.rent.a.car.demo.services.dtos.location.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLocationRequest {


    @NotBlank(message = "Teslim alma konumu boş geçilemez!")
    private String pickUpLocation;

    @NotBlank(message = "Teslim etme konumu boş geçilemez!")
    private String dropOffLocation;
}
