package com.tobeto.rent.a.car.demo.services.dtos.car.requests;

import com.tobeto.rent.a.car.demo.entities.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    @Positive(message = "Doğru Araç id girişi yapınız!")
    private int id;

    @NotBlank(message = "Marka adı boş olamaz!")
    private String brand;

    @NotBlank(message = "Model adı boş olamaz!")
    private String model;

    @Min(value = 2007, message = "Model yılı en az 2007 olmalıdır!")
    private int year;

    @NotBlank(message = "Renk boş olamaz!")
    private String color;

    @NotBlank(message = "Durum boş olamaz!")
    private String status;

    @Positive(message = "Doğru kategori id girişi yapınız!")
    private int categoryId;
}