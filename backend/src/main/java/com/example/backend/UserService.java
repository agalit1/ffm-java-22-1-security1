package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
