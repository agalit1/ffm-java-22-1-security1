package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(NewAppUser newAppUser) {
        String passwordBcrypt = SecurityConfig
                .passwordEncoder
                .encode(newAppUser.password());

        AppUser appUser = new AppUser(
                UUID.randomUUID().toString(),
                newAppUser.username(),
                passwordBcrypt
        );

        userRepository.save(appUser);
    }
}
