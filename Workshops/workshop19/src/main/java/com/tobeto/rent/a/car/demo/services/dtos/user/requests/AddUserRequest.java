package com.tobeto.rent.a.car.demo.services.dtos.user.requests;

import com.tobeto.rent.a.car.demo.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    private String username;

    private String password;

    private String email;

    private List<Role> roles;

}
