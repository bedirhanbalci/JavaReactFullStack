package com.tobeto.rent.a.car.demo.services.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    private int id;

    private String username;

    private String email;

    private String password;

    private String role;

}
