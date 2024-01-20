package com.tobeto.rent.a.car.demo.services.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddUserRequest {

    private String username;

    private String email;

    private String password;

    private String role;

}
