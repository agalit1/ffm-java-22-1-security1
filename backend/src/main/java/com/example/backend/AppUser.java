package com.example.backend;

public record AppUser(
        String id,
        String username,
        String passwordBcrypt
) {
}
