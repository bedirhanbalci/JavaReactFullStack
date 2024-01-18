package com.tobeto.rent.a.car.demo.services.dtos.corporate.requests;

import com.tobeto.rent.a.car.demo.entities.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCorporateRequest {

    @Positive(message = "Doğru Kurumsal id girişi yapınız!")
    private int id;

    @NotBlank(message = "Şirket adı boş olamaz!")
    private String companyName;

    @NotBlank(message = "İletişim adı boş olamaz!")
    private String contactName;

    @NotBlank(message = "Ünvan boş olamaz!")
    private String contactTitle;

    private Customer customerId;
}