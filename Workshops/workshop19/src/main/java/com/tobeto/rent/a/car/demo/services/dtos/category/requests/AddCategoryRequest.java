package com.tobeto.rent.a.car.demo.services.dtos.category.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {

    @NotBlank
    @Length(min = 3, message = "Kategori adı en az 3 haneli olmalıdır!")
    private String name;
}
