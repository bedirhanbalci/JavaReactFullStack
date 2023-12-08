package com.tobeto.rent.a.car.demo.services.dtos.customer.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    @Positive(message = "Doğru Müşteri id girişi yapınız!")
    private int id;

    @NotBlank(message = "Telefon boş olamaz!")
    private String phone;

    @NotBlank(message = "Email boş olamaz!")
    @Email(message = "Email doğru formatta olmalıdır!")
    private String email;

    @NotBlank(message = "Adres boş olamaz!")
    @Length(max = 100, message = "Adres en fazla 100 karakter olabilir!")
    private String address;
}
