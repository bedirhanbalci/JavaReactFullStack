package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.UserService;
import com.tobeto.rent.a.car.demo.services.dtos.user.requests.AddUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody AddUserRequest addUserRequest) {
        userService.register(addUserRequest);
    }

}
