package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.User;
import com.tobeto.rent.a.car.demo.repositories.UserRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.UserService;
import com.tobeto.rent.a.car.demo.services.dtos.user.requests.AddUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(AddUserRequest addUserRequest) {
        User user = User.builder()
                .username(addUserRequest.getUsername())
                .email(addUserRequest.getEmail())
                .authorities(addUserRequest.getRoles())
                .password(passwordEncoder.encode(addUserRequest.getPassword()))
                .build();

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found!"));
    }
}
