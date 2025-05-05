package com.dev.leadBackEngineerTest.controllers;

import com.dev.leadBackEngineerTest.dto.AuthReqDTO;
import com.dev.leadBackEngineerTest.dto.AuthRespDTO;
import com.dev.leadBackEngineerTest.service.AuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${app.security.username}")
    private String configUsername;

    @Value("${app.security.password}")
    private String configPassword;

    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    public AuthController(PasswordEncoder passwordEncoder, AuthService authService) {
        this.passwordEncoder = passwordEncoder;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthRespDTO> login(@RequestBody AuthReqDTO request) {
        if (!configUsername.equals(request.getUsername()) ||
                !passwordEncoder.matches(request.getPassword(), configPassword)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = authService.generateToken(request.getUsername());
        return ResponseEntity.ok(new AuthRespDTO(token));
    }
}
