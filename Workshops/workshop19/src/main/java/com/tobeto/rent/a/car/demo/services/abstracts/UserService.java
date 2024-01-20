package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.user.requests.AddUserRequest;
import com.tobeto.rent.a.car.demo.services.dtos.user.requests.ChangePasswordRequest;
import com.tobeto.rent.a.car.demo.services.dtos.user.responses.GetByIdUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.Principal;

public interface UserService extends UserDetailsService {

    void changePassword(ChangePasswordRequest changePasswordRequest, Principal connectedUser);

    void add(AddUserRequest addUserRequest);

    GetByIdUserResponse getByEmail(String email);

}
