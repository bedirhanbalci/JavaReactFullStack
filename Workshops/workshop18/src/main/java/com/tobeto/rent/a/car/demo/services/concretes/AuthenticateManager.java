package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.config.JwtService;
import com.tobeto.rent.a.car.demo.core.utilities.mappers.ModelMapperService;
import com.tobeto.rent.a.car.demo.entities.Role;
import com.tobeto.rent.a.car.demo.entities.User;
import com.tobeto.rent.a.car.demo.services.abstracts.AuthenticateService;
import com.tobeto.rent.a.car.demo.services.abstracts.UserService;
import com.tobeto.rent.a.car.demo.services.dtos.authenticate.requests.AuthenticateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.authenticate.requests.RegisterRequest;
import com.tobeto.rent.a.car.demo.services.dtos.authenticate.responses.AuthenticateResponse;
import com.tobeto.rent.a.car.demo.services.dtos.user.requests.AddUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticateManager implements AuthenticateService {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapperService modelMapperService;

    private final JwtService jwtService;

    private final AuthenticationManager manager;

    @Override
    public AuthenticateResponse register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userService.add(this.modelMapperService.forRequest().map(user, AddUserRequest.class));
        var jwtToken = jwtService.generateToken(user);

        return AuthenticateResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticateResponse authenticate(AuthenticateRequest request) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userService.getByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(modelMapperService.forResponse().map(user, User.class));
        return AuthenticateResponse.builder()
                .token(jwtToken)
                .build();
    }

}
