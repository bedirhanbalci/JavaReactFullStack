package com.tobeto.rent.a.car.demo.services.dtos.individual.requests;

import com.tobeto.rent.a.car.demo.entities.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualRequest {

    @Positive(message = "Doğru Müşteri id girişi yapınız!")
    private int id;

    @NotBlank(message = "Ad boş olamaz!")
    private String name;

    @NotBlank(message = "Soyad boş olamaz!")
    private String surname;

    @NotNull(message = "Doğum tarihi boş olamaz!")
    @Past(message = "Geçerli bir doğum tarih giriniz.")
    private LocalDate birthDate;

    @NotBlank(message = "Cinsiyet boş olamaz!")
    private String gender;


    private Customer customerId;
}
