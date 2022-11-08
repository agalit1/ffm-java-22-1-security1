package com.example.backend;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/app-users")
@RequiredArgsConstructor
public class AppUserController {

    @GetMapping("/login")
    public void login() {
        }

    @GetMapping("/logout")
        public void logout(HttpSession httpSession) {
        httpSession.invalidate();
    }
}
