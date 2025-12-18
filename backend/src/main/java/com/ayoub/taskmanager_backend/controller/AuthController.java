package com.ayoub.taskmanager_backend.controller;

import com.ayoub.taskmanager_backend.dto.userdto.LoginRequestDTO;
import com.ayoub.taskmanager_backend.dto.userdto.LoginResponseDTO;
import com.ayoub.taskmanager_backend.dto.userdto.RegisterRequestDTO;
import com.ayoub.taskmanager_backend.model.User;
import com.ayoub.taskmanager_backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    private final AuthenticationService authService;


    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(authService.getAllUsers()) ;
    }
}
