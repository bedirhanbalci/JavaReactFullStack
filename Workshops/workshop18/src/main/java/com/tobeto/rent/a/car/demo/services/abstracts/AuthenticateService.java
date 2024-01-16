package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.authenticate.requests.AuthenticateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.authenticate.requests.RegisterRequest;
import com.tobeto.rent.a.car.demo.services.dtos.authenticate.responses.AuthenticateResponse;

public interface AuthenticateService {

    AuthenticateResponse register(RegisterRequest request);

    AuthenticateResponse authenticate(AuthenticateRequest request);
}
