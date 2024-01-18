package com.tobeto.rent.a.car.demo.services.dtos.corporate.requests;

import com.tobeto.rent.a.car.demo.entities.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCorporateRequest {

    @NotBlank(message = "Şirket adı boş olamaz!")
    private String companyName;

    @NotBlank(message = "İletişim adı boş olamaz!")
    private String contactName;

    @NotBlank(message = "Ünvan boş olamaz!")
    private String contactTitle;

    @NotBlank
    @Length(min = 9, message = "Vergi Numarası en az 9 haneli olmalıdır!")
    private String taxNumber;

    private Customer customerId;
}
