package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.AuthenticateService;
import com.tobeto.rent.a.car.demo.services.dtos.authenticate.requests.AuthenticateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.authenticate.requests.RegisterRequest;
import com.tobeto.rent.a.car.demo.services.dtos.authenticate.responses.AuthenticateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authenticates")
@RequiredArgsConstructor
public class AuthenticatesController {

    private final AuthenticateService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticateResponse> register(@RequestBody RegisterRequest request) {

        return ResponseEntity.ok(service.register(request));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequest request) {

        return ResponseEntity.ok(service.authenticate(request));

    }

}
