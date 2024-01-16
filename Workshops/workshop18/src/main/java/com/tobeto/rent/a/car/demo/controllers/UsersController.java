package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.services.abstracts.UserService;
import com.tobeto.rent.a.car.demo.services.dtos.user.requests.AddUserRequest;
import com.tobeto.rent.a.car.demo.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.rent.a.car.demo.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.rent.a.car.demo.services.dtos.user.responses.GetAllUsersResponse;
import com.tobeto.rent.a.car.demo.services.dtos.user.responses.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/users")
public class UsersController {

    private final UserService userService;

    @PostMapping("/add")
    public void add(@RequestBody AddUserRequest request) {

        userService.add(request);

    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteUserRequest request) {

        userService.delete(request);

    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateUserRequest request) {

        userService.update(request);

    }

    @GetMapping("/getAll")
    public List<GetAllUsersResponse> getAll() {

        return userService.getAll();

    }

    @GetMapping("/getById/{id}")
    public GetByIdUserResponse getById(@PathVariable int id) {

        return userService.getById(id);

    }

}
