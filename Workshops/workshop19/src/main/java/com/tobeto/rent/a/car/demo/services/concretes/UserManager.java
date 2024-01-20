package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.core.utilities.mappers.ModelMapperService;
import com.tobeto.rent.a.car.demo.entities.User;
import com.tobeto.rent.a.car.demo.repositories.UserRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.UserService;
import com.tobeto.rent.a.car.demo.services.dtos.user.requests.AddUserRequest;
import com.tobeto.rent.a.car.demo.services.dtos.user.requests.ChangePasswordRequest;
import com.tobeto.rent.a.car.demo.services.dtos.user.responses.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapperService modelMapperService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("No user found!"));
    }

    @Override
    public void changePassword(ChangePasswordRequest changePasswordRequest, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!passwordEncoder.matches(changePasswordRequest.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }

        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));

        userRepository.save(user);
    }

    @Override
    public void add(AddUserRequest addUserRequest) {

        User user = this.modelMapperService.forRequest().map(addUserRequest, User.class);

        this.userRepository.save(user);

    }

    @Override
    public GetByIdUserResponse getByEmail(String email) {

        User user = userRepository.findByEmail(email).orElseThrow();
        GetByIdUserResponse getByIdUserResponse = this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
        return getByIdUserResponse;

    }

}

