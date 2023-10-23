package com.dormbuddy.auth.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<List<User>> getAllUsers() {
        return userRepository.findAllBy();
    }

}
