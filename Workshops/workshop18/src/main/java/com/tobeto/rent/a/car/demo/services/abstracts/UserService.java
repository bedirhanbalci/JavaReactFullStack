package com.tobeto.rent.a.car.demo.services.abstracts;

import com.tobeto.rent.a.car.demo.services.dtos.user.requests.AddUserRequest;
import com.tobeto.rent.a.car.demo.services.dtos.user.requests.DeleteUserRequest;
import com.tobeto.rent.a.car.demo.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.rent.a.car.demo.services.dtos.user.responses.GetAllUsersResponse;
import com.tobeto.rent.a.car.demo.services.dtos.user.responses.GetByIdUserResponse;

import java.util.List;

public interface UserService {

    void add(AddUserRequest request);

    void delete(DeleteUserRequest request);

    void update(UpdateUserRequest request);

    List<GetAllUsersResponse> getAll();

    GetByIdUserResponse getById(int id);


    GetByIdUserResponse getByEmail(String email);

}
