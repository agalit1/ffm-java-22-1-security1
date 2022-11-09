package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/app-users")
@RequiredArgsConstructor
public class AppUserController {

    private final UserService userService;

    @GetMapping("/login")
    public void login() {
    }

    @GetMapping("/logout")
    public void logout(HttpSession httpSession) {
        httpSession.invalidate();
    }

    @GetMapping("/me")
    public String me() {
        User loggedInUser = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return loggedInUser.getUsername();
    }

    @PostMapping
    public void createAppUser(@RequestBody NewAppUser newAppUser) {
        userService.save(newAppUser);
    }
}
