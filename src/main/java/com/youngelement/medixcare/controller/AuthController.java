package com.youngelement.medixcare.controller;

import com.youngelement.medixcare.dto.LoginRequest;
import com.youngelement.medixcare.dto.RegisterRequest;
import com.youngelement.medixcare.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ================= REGISTER =================

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        userService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }

    // ================= LOGIN =================

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        userService.login(request);
        return ResponseEntity.ok("Login successful");
    }
}
