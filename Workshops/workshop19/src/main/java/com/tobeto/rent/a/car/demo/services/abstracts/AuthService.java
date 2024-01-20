package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.entities.User;
import com.tobeto.rent.a.car.demo.services.dtos.auth.requests.LoginRequest;
import com.tobeto.rent.a.car.demo.services.dtos.auth.requests.RegisterRequest;
import com.tobeto.rent.a.car.demo.services.dtos.auth.responses.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthService {

    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse login(LoginRequest loginRequest);


    void saveUserToken(User user, String jwtToken);

    void revokeAllUserTokens(User user);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;


}
